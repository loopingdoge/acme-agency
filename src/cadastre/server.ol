include "cadastre.iol"
include "console.iol"
include "string_utils.iol"
include "math.iol"

inputPort CadastreService {
    Location: "socket://localhost:7779"
    Protocol: soap
    Interfaces: CadastreInterface
}

execution { concurrent }

main {
    cadastrialCoordinates( address )( coordinates ) {
        address.regex = ";";
        split@StringUtils( address )( splitResult );
        if ( #splitResult.result != 6 ) {
            throw ( IncorrectAddress )
        };
        with ( splitResult ) {
            completeAddress.road     = .result[0];
            completeAddress.civic    = .result[1];
            completeAddress.city     = .result[2];
            completeAddress.cap      = .result[3];
            completeAddress.province = .result[4];
            completeAddress.state    = .result[5]
        };
        with ( coordinates ) {
            random@Math()(number);
            round@Math(number * 10000 + 1)(eastNo);
            .east = string( int ( eastNo ) );
            random@Math()(number);
            round@Math(number * 10000 + 1)(nordNo);
            .nord = string ( int ( nordNo ) )
        }
    }
}
