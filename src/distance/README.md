# Distance service

## REST API

`http://service/?from&to`

- `from`:  The URL encoded **origin** address
- `to`: The URL encoded **destination** address 

## Response

The service will return a JSON response by means of the following schema:

```JSON
{
  "message": "A message describing the result",
  "distance": "The distance from origin to destination in meters"
}
```

## Usage

Requirements:

- [Node.js](https://nodejs.org/en/) at least 6.4.0 version
- A [Google Distance Matrix](https://developers.google.com/maps/documentation/distance-matrix/) API key

```
Usage: distance.js -a [env | arg] [name] -p [port]

Options:
  -a, --api   The Google Distance Matrix API key                      [required]
  -p, --port  The server port, defaults to 7778                  [default: 7778]
  -h, --help  Show help                                                [boolean]

Examples:
  distance.js -a env MAPS_API_KEY  Start the service getting the API key from
                                   MAPS_API_KEY environment variable
  distance.js -a arg dd90ka        Start the service using dd90ka as the API key
```

### Example

```shell
$ node distance.js -a env MAPS_API_KEY
```

In another terminal:

```shell
$ curl -X GET http://localhost:7778/Sasso%20Marconi/Bologna

{
    "message": "Distance(m) from [40037 Sasso Marconi, Metropolitan City of Bologna, Italy] to [Bologna, Metropolitan City of Bologna, Italy]",
    "distance": 17356
}
```