include "console.iol"
include "math.iol"
include "bank.iol"

inputPort BankService {
    Location: "socket://localhost:7777"
    Protocol: soap
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

init {
    with (users.IT88T1927501600001011018000) {	// Buyer
        .password = "qwerty";
        .money = 100000
    };
    with (users.IT88T1927501600001011018111) {	// Seller
        .password = "asdfg";
        .money = 300000
    };
    with (users.IT88T1927501600001011018222) {	// ACME
        .password = "zxcvb";
        .money = 5000000
    }
}

main {
    login(request)(loginResponse) {
        if (
            ! #users.(request.username)
            || users.(request.username).password != request.password
        ) {
                exception.message = "Invalid username or password";
                throw( IncorrectLogin, exception )
        } else {
            loginResponse.sid = csets.sid = new;
            username = request.username;
            logged = 1
        }
    };
    println@Console("login from " + username)();

    while (logged) {
        [deposit(request)] {
            users.(username).money += request.amount;
            println@Console(username + " deposited " + request.amount)()
        }

        [withdraw(request)] {
            users.(username).money -= request.amount;
            println@Console(username + " withdrawed " + request.amount)()
        }

        [pay(request)(paymentResponse) {
            if (users.(username).money < request.amount) {
                throw ( InsufficientMoney )
            };
            if (!#users.(request.iban)) {
                throw ( UnexistingIBAN )
            };
            users.(username).money -= request.amount;
            users.(request.iban).money += request.amount;
            println@Console(username + " payed " + request.iban + " a total of " + request.amount + " euros")()
        } ] {
            println@Console(username + " requested a payment to " + request.iban)()
        }

        [loanRequest(request)(loanResponse) {
            random@Math()(randomValue);
            if (randomValue < 0.5) {
                loanResponse.accepted = true
            } else {
                loanResponse.accepted = false
            }
        } ] {
            println@Console(username + " requested a loan of " + request.amount + " euros")()
        }

        [report(request)(requestResponse) {
            requestResponse.amount = users.(username).money
        } ] {
            println@Console(username + " requested a report")()
        }

        [logout(request)] {
            logged = 0;
            println@Console(username + " logout")()
        }
    }
}
