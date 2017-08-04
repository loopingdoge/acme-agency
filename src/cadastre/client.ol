include "cadastre.iol"
include "console.iol"

outputPort CadastreService {
    Location: "socket://localhost:7779"
    Protocol: soap
    Interfaces: CadastreInterface
}

main {
    address = "via dei ciclamini;16;marzabotto;40043;bologna;italy";
    request.address = address;
    cadastrialCoordinates@CadastreService(request)(response);
    with( response ){
        println@Console("Error: " + .error)();
        println@Console("Nord coordinate: " + .coordinates.nord)();
        println@Console("East coordinate: " + .coordinates.east)()
    }
}
