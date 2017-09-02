@echo off
SET ACME_ROOT=%~dp0\..

cd %ACME_ROOT%\src\cadastre
start jolie server.ol

cd %ACME_ROOT%\src\bank
start jolie server.ol

cd %ACME_ROOT%\src\camunda-session-manager
start jolie session_manager.ol

cd %ACME_ROOT%\src\mail 
start node mail.js

cd %ACME_ROOT%\src\distance
start node distance.js -a env MAPS_API_KEY

cd %ACME_ROOT%