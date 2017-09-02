@echo off
SET ACME_ROOT=%~dp0\..

wsimport -Xnocompile -keep -p org.loopingdoge.acme.jolie.cadastre -s %ACME_ROOT%\src\acme-agency\src\main\java -extension %ACME_ROOT%\src\cadastre\cadastre.wsdl

wsimport -Xnocompile -keep -p org.loopingdoge.acme.jolie.sessionmanager -s %ACME_ROOT%\src\acme-agency\src\main\java -extension %ACME_ROOT%\src\camunda-session-manager\acme_session_manager.wsdl

wsimport -Xnocompile -keep -p org.loopingdoge.acme.jolie.bank -s %ACME_ROOT%\src\java-buyer\src -extension %ACME_ROOT%\src\bank\bank.wsdl

wsimport -Xnocompile -keep -p org.loopingdoge.acme.jolie.sessionmanager -s %ACME_ROOT%\src\java-buyer\src -extension %ACME_ROOT%\src\camunda-session-manager\client_session_manager.wsdl

wsimport -Xnocompile -keep -p org.loopingdoge.acme.jolie.sessionmanager -s %ACME_ROOT%\src\java-seller\src -extension %ACME_ROOT%\src\camunda-session-manager\client_session_manager.wsdl
