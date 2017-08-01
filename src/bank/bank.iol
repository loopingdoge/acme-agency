type LoginRequest: void {
	.username: string
	.password: string
}

type LoginResponse: void {
	.sid: string
}

type IncorrectLoginEx: void {
	.message: string
}

type SimpleRequest: void {
	.sid: string
}

type WithdrawRequest: void {
	.sid: string
	.amount: int
}

type DepositRequest: void {
	.sid: string
	.amount: int
}

type PaymentRequest: void {
	.sid: string
	.amount: int
	.iban: string
}

type ReportResponse: void {
	.amount: int
}

type LoanRequest: void {
	.sid: string
	.amount: int
}

type LoanResponse: void {
	.accepted: bool
}

interface BankInterface {
	RequestResponse:
		login(LoginRequest)(LoginResponse) throws IncorrectLogin( IncorrectLoginEx ),
		report(SimpleRequest)(ReportResponse),
		loanRequest(LoanRequest)(LoanResponse),
		pay(PaymentRequest)(void) throws InsufficientMoney( void ) UnexistingIBAN( void )
	OneWay:
		withdraw(WithdrawRequest),
		deposit(DepositRequest),
		logout(SimpleRequest)
}
