include "console.iol"
include "file.iol"
include "session_manager.iol"
include "string_utils.iol"

inputPort ACMESessionServer {
	Location: "socket://localhost:8844"
	Protocol: soap {
		.wsdl = "./acme_session_manager.wsdl";
		.wsdl.port = "ACMESessionManagerServicePort";
		.namespace = "org.loopingdoge.acme.jolie.sessionmanager.xsd";
		.dropRootValue = true
	}
	Interfaces: ACMESessionManager
}

inputPort ClientSessionServer {
	Location: "socket://localhost:8845"
	Protocol: soap {
		.wsdl = "./client_session_manager.wsdl";
		.wsdl.port = "ClientSessionManagerServicePort";
		.namespace = "org.loopingdoge.acme.jolie.sessionmanager.xsd";
		.dropRootValue = true
	}
	Interfaces: ClientSessionManager
}

execution {concurrent} 

init {
	readFileRequest.filename = "sessions.json";
	readFileRequest.format = "json";
	writeFileRequest.filename = "sessions.json";
	writeFileRequest.format = "json"
}

main {

	[addSession(sessionAdd)(response) {
		println@Console("Requested add...")();

		newsession.nextUser = sessionAdd.nextUser;
		newsession.processId = sessionAdd.processId;
		newsession.state = sessionAdd.state;

		synchronized(sessions) {
			readFile@File(readFileRequest)(sessionList);
		
			// Check if id is already present
			toAdd = true;
			for (i = 0, i < #sessionList.sessions, i++) {
				if (is_defined(sessionList.sessions[i])) {
					if (sessionList.sessions[i].processId == sessionAdd.processId) {
						toAdd = false
					}
				}
			};

			if (toAdd == true) {
				sessionList.sessions[#sessionList.sessions] << newsession;
				writeFileRequest.content << sessionList;
				writeFile@File(writeFileRequest)();
				response.message = "Ok" 
			}
			else {
				response.message = "Id already present" 
			}	
		};

		println@Console("Done\n")()
	}] {nullProcess}

	[removeSession(sessionDel)(response) {
		println@Console("Requested remove...")();
		
		synchronized(sessions) {
			readFile@File(readFileRequest)(sessionList);

			for (i = 0, i < #sessionList.sessions, i++) {
				if (is_defined(sessionList.sessions[i])) {
					if (sessionList.sessions[i].processId == sessionDel.processId) {
						undef (sessionList.sessions[i])
					}
				}
			};
			writeFileRequest.content << sessionList;
			writeFile@File(writeFileRequest)()
		};

		response.message = "Ok"; 
		println@Console("Done\n")()
	}] {nullProcess}

	[getSessions(sessionGet)(response) {
		println@Console("Requested get for '" + sessionGet.username + "'...")();
		
		synchronized(sessions) {
			readFile@File(readFileRequest)(sessionList);
			for (i = 0, i < #sessionList.sessions, i++) {
				if (is_defined(sessionList.sessions[i])) {
					if (sessionList.sessions[i].nextUser == sessionGet.username) {
						userSessionList[#userSessionList] << sessionList.sessions[i]
					}
				}
			}
		};

		response.sessions << userSessionList;
		response.message = "Ok";
	
		println@Console("Done\n")()
	}] {nullProcess}
}
