type Address: string

type CompleteAddress: void {
    .road: string
    .civic: string
    .city: string
    .cap: string
    .province: string
    .state: string
}

type Coordinate: void {
    .nord: string
    .east: string
}

type IncorrectAddressEx: void

interface CadastreInterface {
    RequestResponse:
        cadastrialCoordinates(Address)(Coordinate) throws IncorrectAddress( IncorrectAddressEx )
}
