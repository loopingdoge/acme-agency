# Bank service

## Interface

| Name     | Input type                          | Output type                           |
| -------- | ----------------------------------- | ------------------------------------- |
| deposit  | [DepositRequest](#depositrequest)   |                                       |
| loan     | [LoanRequest](#loanrequest)         | [LoanResponse](#loanresponse)         |
| login    | [LoginRequest](#loginrequest)       | [LoginResponse](#loginresponse)       |
| logout   | [LogoutRequest](#simplerequest)     |                                       |
| pay      | [PaymentRequest](#paymentrequest)   | [PaymentResponse](#paymentresponse)   |
| report   | [ReportRequest](#simplerequest)     | [ReportResponse](#reportresponse)     |
| withdraw | [WithdrawRequest](#withdrawrequest) | [WithdrawResponse](#withdrawresponse) |

## Types

### DepositRequest

```json
{
  "sid": "string",
  "amount": "double"
}
```

### LoanRequest

```json
{
  "sid": "string",
  "amount": "double"
}
```

### LoanResponse

```json
{
  "accepted": "boolean"
}
```

### LoginRequest

```json
{
  "username": "string",
  "password": "string"
}
```

### LoginResponse

```json
{
  "error": "boolean",
  "sid": "string"
}
```

### SimpleRequest

```json
{
  "sid": "string"
}
```

### PaymentRequest

```json
{
  "amount": "double",
  "iban": "string",
  "sid": "string"
}
```

### PaymentResponse

```json
{
  "errors": {
    "unexistingIban": "boolean",
    "insufficientMoney": "boolean"
  }
}
```

### ReportResponse

```json
{
  ".amount": "double"
}
```

### WithdrawRequest

```json
{
  "amount": "double",
  "sid": "string"
}
```

### WithdrawResponse

```json
{
  "error": "boolean"
}

```