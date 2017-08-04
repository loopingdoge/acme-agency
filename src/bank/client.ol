include "console.iol"
include "bank.iol"

outputPort BankService {
    Location: "socket://localhost:7777"
    Protocol: soap
    Interfaces: BankInterface
}

main {

    scope ( client_1 ) {
        install(
            IncorrectLogin => println@Console("client 1 - " + "Login error: wrong username or password")()
        );
        user1.name = "IT88T1927501600001011018000"; user1.password = "qwerty";

        loginRequest1.username = user1.name;
        loginRequest1.password = user1.password;
        login@BankService(loginRequest1)(response1);
        if ( response1.error ) {
            throw( IncorrectLogin )
        };
        sid1 = response1.sid;

        depositRequest1.sid = sid1;
        depositRequest1.amount = 50.35;
        deposit@BankService(depositRequest1);

        scope ( client_1_withdraw ) {
            install(
                InsufficientMoney => println@Console("client 1 - " + "Insufficient money to withdraw")()
            );
            withdrawRequest1.sid = sid1;
            withdrawRequest1.amount = 30;
            withdraw@BankService(withdrawRequest1)(withdrawResponse1);
            if ( withdrawResponse1.error ) {
                throw( InsufficientMoney )
            }
        };

        loanRequest1.sid = sid1;
        loanRequest1.amount = 100000;
        loan@BankService(loanRequest1)(loanResponse1);
        if (loanResponse1.accepted) { acceptedStr = "accepted" } else { acceptedStr = "rejected" };
        println@Console("client 1 - " + "The bank " + acceptedStr + " my loan request")();

        reportRequest1.sid = sid1;
        report@BankService(reportRequest1)(response1);
        println@Console("client 1 - " + "I have got " + response1.amount + " money in my bank")();

        logoutRequest1.sid = sid1;
        logout@BankService(logoutRequest1)
    }
    |
    scope ( client_2 ) {
        install(
            IncorrectLogin => println@Console("client 2 - " + "Login error: wrong username or password")()
        );
        user2.name = "IT88T1927501600001011018111"; user2.password = "asdfg";

        loginRequest2.username = user2.name;
        loginRequest2.password = user2.password;
        login@BankService(loginRequest2)(response2);
        if ( response2.error ) {
            throw( IncorrectLogin )
        };
        sid2 = response2.sid;

        depositRequest2.sid = sid2;
        depositRequest2.amount = 100;
        deposit@BankService(depositRequest2);

        scope ( client_2_payment ) {
            install(
                PaymentInsufficientMoney => println@Console("client 2 - " + "Payment error: you don't have enough money")(),
                PaymentUnexistingIban => println@Console("client 2 - " + "Payment error: unexisting iban")()
            );
            paymentRequest2.sid = sid2;
            paymentRequest2.amount = 1000;
            paymentRequest2.iban = "IT88T1927501600001011018000";
            pay@BankService(paymentRequest2)(paymentResponse2);
            if ( paymentResponse2.errors.insufficientMoney ) {
                throw( PaymentInsufficientMoney )
            } else if ( paymentResponse2.errors.unexistingIban ) {
                throw( PaymentUnexistingIban )
            }
        };

        reportRequest2.sid = sid2;
        report@BankService(reportRequest2)(response2);
        println@Console("client 2 - " + "I have got " + response2.amount + " money in my bank")();

        logoutRequest2.sid = sid2;
        logout@BankService(logoutRequest2)
    }
}
