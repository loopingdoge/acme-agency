type Address: string

// Only for documentative purpose
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

type Response: void {
    .coordinates: Coordinate
    .error: string
}

interface CadastreInterface {
    RequestResponse:
        cadastrialCoordinates(Address)(Response)
}
