# Cadastre Service

## API

The service requires a `string` parameter representing the `address` in the following **CSV** format:

```
road;civic;city;cap;province;state
```

### Response

The response follows the following schema:

```json
{
  "error": "string",
  "coordinates": {
    "nord": "string",
    "east": "string"
  }
}
```

If the address format is not correct, the `error` field will be set and the `nord` and `east` fields will be set to `0`.