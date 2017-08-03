include "console.iol"
include "bank.iol"

outputPort BankService {
    Location: "socket://localhost:7777"
    Protocol: soap
    Interfaces: BankInterface
}

main {

    install(
        InsufficientMoney => println@Console("I have not enough money")(),
        UnexistingIBAN => println@Console("I am literally throwing away my money")(),
        IncorrectLogin => println@Console(main.IncorrectLogin.message)()
    );

    {
        user1.name = "IT88T1927501600001011018000"; user1.password = "qwerty";

        loginRequest1.username = user1.name;
        loginRequest1.password = user1.password;
        login@BankService(loginRequest1)(response1);
        sid1 = response1.sid;

        depositRequest1.sid = sid1;
        depositRequest1.amount = 50;
        deposit@BankService(depositRequest1);

        withdrawRequest1.sid = sid1;
        withdrawRequest1.amount = 30;
        withdraw@BankService(withdrawRequest1);

        loanRequest1.sid = sid1;
        loanRequest1.amount = 100000;
        loanRequest@BankService(loanRequest1)(loanResponse1);
        if (loanResponse1.accepted) { acceptedStr = "accepted" } else { acceptedStr = "rejected" };
        println@Console("The bank " + acceptedStr + " my loan request")();

        reportRequest1.sid = sid1;
        report@BankService(reportRequest1)(response1);
        println@Console("I am " + user1.name + " and I have got " + response1.amount + " money in my bank")();

        logoutRequest1.sid = sid1;
        logout@BankService(logoutRequest1)
    }
    |
    {
        user2.name = "IT88T1927501600001011018111"; user2.password = "asdfg";

        loginRequest2.username = user2.name;
        loginRequest2.password = user2.password;
        login@BankService(loginRequest2)(response2);
        sid2 = response2.sid;

        depositRequest2.sid = sid2;
        depositRequest2.amount = 100;
        deposit@BankService(depositRequest2);

        withdrawRequest2.sid = sid2;
        withdrawRequest2.amount = 30;
        withdraw@BankService(withdrawRequest2);

        paymentRequest2.sid = sid2;
        paymentRequest2.amount = 10;
        paymentRequest2.iban = "IT88T1927501600001011018000";
        pay@BankService(paymentRequest2)();

        reportRequest2.sid = sid2;
        report@BankService(reportRequest2)(response2);
        println@Console("I am " + user2.name + " and I have got " + response2.amount + " money in my bank")();

        logoutRequest2.sid = sid2;
        logout@BankService(logoutRequest2)
    }
}
