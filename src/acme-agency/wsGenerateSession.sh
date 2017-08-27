#!/bin/bash

wsimport -keep -p org.loopingdoge.acme.jolie.sessionmanager -s ./src/main/java -extension ../camunda-session-manager/acme_session_manager.wsdl
