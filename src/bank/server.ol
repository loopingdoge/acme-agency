include "bank.iol"
include "console.iol"
include "math.iol"
include "time.iol"

inputPort BankService {
    Location: "socket://localhost:7777"
    Protocol: soap {
	.wsdl = "./bank.wsdl";
        .wsdl.port = "BankInterfaceServicePort";
        .namespace = "org.loopingdoge.acme.jolie.bank.xsd";
        .dropRootValue = true
    }
    Interfaces: BankInterface
}

execution{ concurrent }

cset {
    sid:
        LoginResponse.sid
        SimpleRequest.sid
        WithdrawRequest.sid
        DepositRequest.sid
        PaymentRequest.sid
        LoanRequest.sid
}

define roundRequestAmount {
    request.amount.decimals = 2;
    round@Math(request.amount)(roundedAmount)
}

define timestamp {
    getCurrentDateTime@Time()( time )
}

define log {
    timestamp;
    println@Console( time + " " + logmessage )()
}

init {
    with ( users.IT88T1927501600001011018000 ) {	// Buyer
        .password = "qwerty";
        .money = 400000.00
    };
    with ( users.IT88T1927501600001011018111 ) {	// Seller
        .password = "asdfg";
        .money = 300000.00
    };
    with ( users.IT88T1927501600001011018222 ) {	// ACME
        .password = "zxcvb";
        .money = 5000000.00
    };
    timestamp
}

main {
    login( request )( loginResponse ) {
        logmessage = "login request from " + request.username + " ..."; log;
        if (
            ! #users.(request.username) ||
            users.(request.username).password != request.password
        ) {
            loginResponse.error = true;
            loginResponse.sid = "0";
            logmessage = "login request from " + request.username + " denied"; log
        } else {
            loginResponse.error = false;
            loginResponse.sid = csets.sid = new;
            username = request.username;
            logged = 1;
            logmessage = "login request from " + request.username + " accepted"; log
        }
    };

    while (logged) {
        [deposit(request)] {
            roundRequestAmount;
            users.(username).money += roundedAmount;
            logmessage = username + " deposited " + roundedAmount + " euros"; log
        }

        [withdraw(request)(withdrawResponse) {
            roundRequestAmount;
            if ( users.(username).money >= roundedAmount ) {
                users.(username).money -= roundedAmount;
                withdrawResponse.error = false;
                logmessage = username + " withdrawed " + roundedAmount + " euros"; log
            } else {
                withdrawResponse.error = true;
                logmessage = username + " withdraw was refused due to insufficient money"; log
            }
        } ]

        [pay(request)(paymentResponse) {
            roundRequestAmount;
            logmessage = username + " requested a payment to " + request.iban; log;
            with( paymentResponse ) {
                if (users.(username).money < roundedAmount) {
                    .errors.insufficientMoney = true;
                    logmessage = username + " payment refused due to insufficient money"; log
                } else {
                    .errors.insufficientMoney = false
                };

                if (!#users.(request.iban)) {
                   .errors.unexistingIban = true;
                   logmessage = username + " payment refused due to unexisting iban"; log
               } else {
                   .errors.unexistingIban = false
               };

               if (!.errors.insufficientMoney && !.errors.unexistingIban) {
                   users.(username).money -= roundedAmount;
                   users.(request.iban).money += roundedAmount;
                   logmessage = username + " payed " + request.iban + " a total of " + roundedAmount + " euros"; log
               }
            }
        } ]

        [loan(request)(loanResponse) {
            logmessage = username + " requested a loan of " + request.amount + " euros"; log;
            random@Math()(randomValue);
            if (randomValue < 0.5) {
                loanResponse.accepted = true
            } else {
                loanResponse.accepted = false
            };
            if (loanResponse.accepted) { acceptedStr = "accepted" } else { acceptedStr = "rejected" };
            logmessage = username + "'s loan was " + acceptedStr; log
        } ]

        [report(request)(requestResponse) {
            requestResponse.amount = users.(username).money;
            logmessage = username + " requested a report"; log
        } ]

        [logout(request)] {
            logged = 0;
            logmessage = username + " logout"; log
        }
    }
}
