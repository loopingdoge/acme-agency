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

type LogoutRequest: void {
    .sid: string
}

type ReportRequest: void {
    .sid: string
}

type PaymentRequest: void {
    .sid: string
    .amount: double
    .user: string
}

type PaymentErrors: void {
    .unexistingUser: bool
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
        report(ReportRequest)(ReportResponse),
        pay(PaymentRequest)(PaymentResponse)
    OneWay:
        deposit(DepositRequest),
        logout(LogoutRequest)
}

type PostMailRequest: void {
    .username: string
    .from: string
    .text: string
}

type PostMailResponse: void {
}

/**! @Rest: method=post, template=/{username} */
interface MailInterface {
    RequestResponse:
        sendMail(PostMailRequest)(PostMailResponse)
}
