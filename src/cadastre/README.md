# Cadastre Service

## Interface

| Name                  | Input type          | Output type                              |
| --------------------- | ------------------- | ---------------------------------------- |
| cadastrialCoordinates | [Address](#address) | [CoordinateResponse](#coordinateresponse) |

## Types

### Address

```json
{
  "address": "string"
}
```

The  `address` must respect the following **CSV** format:

```
road;civic;city;cap;province;state
```

### CoordinateResponse

```json
{
  "error": "string",
  "coordinates": {
    "nord": "string",
    "east": "string"
  }
}
```

If the address format is not correct, the `error` field will be set and the `nord` and `east` fields will be set to `"0"`.