wsimport -keep -p org.loopingdoge.acme.jolie.cadastre -s src\acme-agency\src\main\java -extension src\cadastre\cadastre.wsdl

wsimport -keep -p org.loopingdoge.acme.jolie.sessionmanager -s src\acme-agency\src\main\java -extension src\camunda-session-manager\acme_session_manager.wsdl

wsimport -keep -p soseng.project.wsinterface -s src\java-buyer\src -extension http://localhost:8080/acme-agency-ws-0.0.1-SNAPSHOT/BuyerWebService?wsdl

wsimport -keep -p org.loopingdoge.acme.jolie.sessionmanager -s src\java-buyer\src -extension src\camunda-session-manager\client_session_manager.wsdl

wsimport -keep -p org.loopingdoge.acme.jolie.bank -s src\java-buyer\src -extension src\bank\bank.wsdl

wsimport -keep -p soseng.project.wsinterface -s src\java-seller\src -extension http://localhost:8080/acme-agency-ws-0.0.1-SNAPSHOT/SellerWebService?wsdl

wsimport -keep -p org.loopingdoge.acme.jolie.sessionmanager -s src\java-seller\src -extension src\camunda-session-manager\client_session_manager.wsdl
