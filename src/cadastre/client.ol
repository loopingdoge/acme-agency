include "cadastre.iol"
include "console.iol"

outputPort CadastreService {
    Location: "socket://localhost:7779"
    Protocol: soap
    Interfaces: CadastreInterface
}

main {
    address = "via dei ciclamini;16;marzabotto;40043;bologna;italia";
    cadastrialCoordinates@CadastreService(address)(cadastrialCoordinates);
    with( cadastrialCoordinates ){
        println@Console(.nord)();
        println@Console(.east)()
    }
}
