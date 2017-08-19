#!/bin/bash

# Generate Jolie interface from WSDL file
# Then removes the first line of created file

wsdl2jolie http://localhost:8080/acme-agency-ws-0.0.1-SNAPSHOT/SellerWebService?WSDL > GeneratedInterface.iol;
echo "$(tail -n +2 GeneratedInterface.iol)" > GeneratedInterface.iol
