include "cadastre.iol"
include "console.iol"
include "string_utils.iol"
include "math.iol"

inputPort Cadastre {
    Location: "socket://localhost:7779"
    Protocol: soap {
        .dropRootValue = true;
        .compabilityMode = true;
        .namespace = "org.loopingdoge.acme.jolie.cadastre.xsd"
    }
    Interfaces: CadastreInterface
}

execution { concurrent }

define genRandomCoordinate {
    random@Math()( number );
    round@Math( number * 10000 + 1 )( randomCoordinate )
}

main {
    cadastrialCoordinates( request )( response ) {
        println@Console( request.address )();
        address = request.address;
        address.regex = ";";
        split@StringUtils( address )( splitResult );
        if ( #splitResult.result != 6 ) {
            with ( response ) {
                .error = "Incorrect address format";
                .coordinates.nord = "0";
                .coordinates.east = "0"
            };
            println@Console( response.error )()
        } else {
            with ( splitResult ) {
                completeAddress.road     = .result[0];
                completeAddress.civic    = .result[1];
                completeAddress.city     = .result[2];
                completeAddress.cap      = .result[3];
                completeAddress.province = .result[4];
                completeAddress.state    = .result[5]
            };
            with( response ){
                .error = "";
                genRandomCoordinate;
                .coordinates.east = string( int ( randomCoordinate ) );
                genRandomCoordinate;
                .coordinates.nord = string ( int ( randomCoordinate ) )
            }
        }
    }
}
