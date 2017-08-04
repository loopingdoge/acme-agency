type DepositRequest: void {
    .sid: string
    .amount: double
}

type LoanRequest: void {
    .sid: string
    .amount: double
}

type LoanResponse: void {
    .accepted: bool
}

type LoginRequest: void {
    .username: string
    .password: string
}

type LoginResponse: void {
    .error: bool
    .sid: string
}

type SimpleRequest: void {
    .sid: string
}

type PaymentRequest: void {
    .sid: string
    .amount: double
    .iban: string
}

type PaymentErrors: void {
    .unexistingIban: bool
    .insufficientMoney: bool
}

type PaymentResponse: void {
    .errors: PaymentErrors
}

type ReportResponse: void {
    .amount: double
}

type WithdrawRequest: void {
    .sid: string
    .amount: double
}

type WithdrawResponse: void {
    .error: bool
}

interface BankInterface {
    RequestResponse:
        loan(LoanRequest)(LoanResponse),
        login(LoginRequest)(LoginResponse),
        withdraw(WithdrawRequest)(WithdrawResponse),
        report(SimpleRequest)(ReportResponse),
        pay(PaymentRequest)(PaymentResponse)
    OneWay:
        deposit(DepositRequest),
        logout(SimpleRequest)
}
