# Session Service

Service external to Acme main process. Used by clients to resume previous sessions and updated by Acme after the completion of each task.

## Acme Interface

| Name            | Input type          | Output type                |
| ----------------| ------------------- | ---------------------------|
| addSession      | [Session](#session) | String (result)            |
| removeSession   | String (processId)  | String (result)            |
| getSession      | String (username)   | List<[Session]>(#session)  |

## Client Interface

| Name               | Input type          | Output type                |
| ------------------ | ------------------- | ---------------------------|
| getSession         | String (username)   | List<[Session]>(#session)  |
| informPaymentDone  | [Payment](#payment) | String (result)            |

## Types

### Session

```json
{
  "nextUser": "string",
  "processId": "string",
  "state": "string"
}
```

### Payment

```json
{
  "processId": "string",
  "bankOpInfo": "string"
}
```

The parameter *bankOpInfo* could be used by the server to check payment data, but it is not implemented.

