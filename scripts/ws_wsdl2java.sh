#!/bin/bash
SCRIPTDIR=`dirname "$0"`
ACME_ROOT=${SCRIPTDIR}/..

# acme-agency-ws interface for java-buyer
wsimport -Xnocompile -keep -p soseng.project.wsinterface -s $ACME_ROOT/src/java-buyer/src -extension http://localhost:8080/acme-agency-ws-0.0.1-SNAPSHOT/BuyerWebService?wsdl

# acme-agency-ws interface for java-seller
wsimport -Xnocompile -keep -p soseng.project.wsinterface -s $ACME_ROOT/src/java-seller/src -extension http://localhost:8080/acme-agency-ws-0.0.1-SNAPSHOT/SellerWebService?wsdl
