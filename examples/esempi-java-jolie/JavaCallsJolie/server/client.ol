include "Interface.iol"
include "console.iol"

outputPort Server {
        Location: "socket://localhost:8000"
        Protocol: soap
        Interfaces: ServiceForJavaInterface
}

main {
	pair.x = 10;
	pair.y = 15;

	stringArray.strings[0] = "Ah";
	stringArray.strings[1] = "Boh";
	stringArray.strings[2] = "NonSo";

        println@Console("Sending")();
	sum@Server(pair)(response);
	println@Console("Received " + response.result)();
        
	println@Console("Sending")();
	concatenate@Server(stringArray)(response);
	println@Console("Received " + response.result)()
}

