include "console.iol"
include "file.iol"
include "session_manager.iol"
include "string_utils.iol"

inputPort ACMESessionServer {
	Location: "socket://localhost:8844"
	Protocol: soap {
		.namespace = "org.loopingdoge.acme.jolie.sessionmanager.xsd";
		.dropRootValue = true
	}
	Interfaces: ACMESessionManager
}

inputPort ClientSessionServer {
	Location: "socket://localhost:8845"
	Protocol: soap {
		.namespace = "org.loopingdoge.acme.jolie.sessionmanager.xsd";
		.dropRootValue = true
	}
	Interfaces: ClientSessionManager
}

execution {concurrent}

constants {
	SESSION_FILE_NAME = "sessions.json",
	WAIT_BUYER_DEPOSIT = "WaitingForBuyerDeposit",
	WAIT_BUYER_PAYMENT = "WaitingForBuyerPayment", 
	PAYMENT_BEING_VERIFIED = "PaymentBeingVerified" 
}

init {
	readFileRequest.filename = SESSION_FILE_NAME;
	readFileRequest.format = "json";
	writeFileRequest.filename = SESSION_FILE_NAME;
	writeFileRequest.format = "json";


	exists@File(SESSION_FILE_NAME)(b);
	
	if(!b) {
		wfr.content = "{}";
		wfr.format = "text";
		wfr.filename = SESSION_FILE_NAME;
		writeFile@File(wfr)()
	}
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

	[informDepositDone(depositInfo)(response) {
		println@Console("Inform deposit " + depositInfo.processId + " ...")();

		synchronized(sessions) {
			readFile@File(readFileRequest)(sessionList);
			for (i = 0, i < #sessionList.sessions, i++) {
				if (is_defined(sessionList.sessions[i])) {
					if (sessionList.sessions[i].processId == depositInfo.processId) {
						depositSession << sessionList.sessions[i];
						index << i
					}
				}
			}
		};

		if (is_defined(depositSession) && depositSession.state == WAIT_BUYER_DEPOSIT) {
			sessionList.sessions[index].state << WAIT_BUYER_PAYMENT;

			synchronized(sessions) {	
				writeFileRequest.content << sessionList;
				writeFile@File(writeFileRequest)()
			};

			response.message = "Ok"
		}
		else {
			response.message = "Non-existing process"
		};
		
		println@Console("Done\n")()
	}] {nullProcess}
	
	[informPaymentDone(paymentInfo)(response) {
		println@Console("Inform payment " + paymentInfo.processId + " ...")();

		synchronized(sessions) {
			readFile@File(readFileRequest)(sessionList);
			for (i = 0, i < #sessionList.sessions, i++) {
				if (is_defined(sessionList.sessions[i])) {
					if (sessionList.sessions[i].processId == paymentInfo.processId) {
						paymentSession << sessionList.sessions[i];
						index << i
					}
				}
			}
		};

		if (is_defined(paymentSession) && paymentSession.state == WAIT_BUYER_PAYMENT) {
			sessionList.sessions[index].state << PAYMENT_BEING_VERIFIED;

			synchronized(sessions) {	
				writeFileRequest.content << sessionList;
				writeFile@File(writeFileRequest)()
			};

			response.message = "Ok"
		}
		else {
			response.message = "Non-existing process"
		};
		
		println@Console("Done\n")()
	}] {nullProcess}
}
