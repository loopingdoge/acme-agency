#!/bin/bash
SCRIPTDIR=`dirname "$0"`
ACME_ROOT=${SCRIPTDIR}/..

# cadastre interface for acme-agency 
wsimport -Xnocompile -keep -p org.loopingdoge.acme.jolie.cadastre -s $ACME_ROOT/src/acme-agency/src/main/java -extension $ACME_ROOT/src/cadastre/cadastre.wsdl

# session-manager interface for acme-agency 
wsimport -Xnocompile -keep -p org.loopingdoge.acme.jolie.sessionmanager -s $ACME_ROOT/src/acme-agency/src/main/java -extension $ACME_ROOT/src/camunda-session-manager/acme_session_manager.wsdl

# session-manager interface for java-buyer
wsimport -Xnocompile -keep -p org.loopingdoge.acme.jolie.sessionmanager -s $ACME_ROOT/src/java-buyer/src -extension $ACME_ROOT/src/camunda-session-manager/client_session_manager.wsdl

# bank interface for java-buyer
wsimport -Xnocompile -keep -p org.loopingdoge.acme.jolie.bank -s $ACME_ROOT/src/java-buyer/src -extension $ACME_ROOT/src/bank/bank.wsdl

# session-manager interface for java-seller
wsimport -Xnocompile -keep -p org.loopingdoge.acme.jolie.sessionmanager -s $ACME_ROOT/src/java-seller/src -extension $ACME_ROOT/src/camunda-session-manager/client_session_manager.wsdl
