# Mail service

## REST API

### GET http://service/:user?unread=boolean

Returns the mails of the given `user`.

If unread is set to true, the service will return only the mails that hasn't been returned yet.

The service will return a JSON response by means of the following schema:

```JSON
{
  "mails": [
        {
            "from": "string",
            "to": "string",
            "text": "string",
            "read": "boolean"
        }
    ]
}
```

### POST http://service/:user 

Send a mail to `user`.

POST body:

```json
{
    "from": "string",
    "text": "string"
}
```

The service will return a JSON response by means of the following schema:

```json
{
    "error": "string"
}
```

## Usage

Requirements:

- [Node.js](https://nodejs.org/en/) at least 6.4.0 version

```
Usage: -p [port]

Options:
  -p, --port  The server port, defaults to 7778                  [default: 7774]
  -h, --help  Show help                                                [boolean]
```
