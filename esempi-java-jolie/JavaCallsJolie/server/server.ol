include "Interface.iol"
include "console.iol"

inputPort ServiceForJava {
        Location: "socket://localhost:8000"
        Protocol: soap {
		.wsdl = "./serviceforjava.wsdl";
		.wsdl.port = "ServiceForJavaServicePort";
		.dropRootValue = true
	}
        Interfaces: ServiceForJavaInterface
}

execution {concurrent}

main {
	[sum(pair)(response) {
		println@Console("Sum " + pair.x + " " + pair.y)();
		response.result = pair.x + pair.y
	}] {nullProcess}

	[concatenate(stringArray)(response) {
		conc = "";
		for (i = 0, i < #stringArray.strings, i++) {
			println@Console("String[" + i + "] : " + stringArray.strings[i])();
			conc = conc + stringArray.strings[i]
		};
		response.result = conc
	}] {nullProcess}
}

