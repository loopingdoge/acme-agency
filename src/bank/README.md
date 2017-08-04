# Bank service

## Interface

| Name     | Input type                          | Output type                           |
| -------- | ----------------------------------- | ------------------------------------- |
| deposit  | [DepositRequest](#DepositRequest)   |                                       |
| loan     | [LoanRequest](#LoanRequest)         | [LoanResponse](#LoanResponse)         |
| login    | [LoginRequest](#LoginRequest)       | [LoginResponse](#LoginResponse)       |
| logout   | [SimpleRequest](#SimpleRequest)     |                                       |
| pay      | [PaymentRequest](#PaymentRequest)   | [PaymentResponse](#PaymentResponse)   |
| report   | [SimpleRequest](#SimpleRequest)     | [ReportResponse](#ReportResponse)     |
| withdraw | [WithdrawRequest](#WithdrawRequest) | [WithdrawResponse](#WithdrawResponse) |

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