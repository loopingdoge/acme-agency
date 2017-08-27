#!/bin/bash

jolie2wsdl --namespace org.loopingdoge.acme.jolie.sessionmanager --portName ACMESessionServer --portAddr http://localhost:8844 --o acme_session_manager.wsdl session_manager.ol;

jolie2wsdl --namespace org.loopingdoge.acme.jolie.sessionmanager --portName ClientSessionServer --portAddr http://localhost:8845 --o client_session_manager.wsdl session_manager.ol
