include "GeneratedInterface.iol"
include "console.iol"

main {
	msg.arg0 = "Sarassassa";
	sayHello@HelloServicePort(msg)(response);
	println@Console(response.return)()
}
