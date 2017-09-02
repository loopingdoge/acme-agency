@echo off
SET ACME_ROOT=%~dp0\..

wsimport -keep -Xnocompile -p soseng.project.wsinterface -s %ACME_ROOT%\src\java-buyer\src -extension http://localhost:8080/acme-agency-ws-0.0.1-SNAPSHOT/BuyerWebService?wsdl

wsimport -keep -Xnocompile -p soseng.project.wsinterface -s %ACME_ROOT%\src\java-seller\src -extension http://localhost:8080/acme-agency-ws-0.0.1-SNAPSHOT/SellerWebService?wsdl