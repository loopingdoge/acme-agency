#!/bin/bash

# Generate Jolie interface from WSDL file

# Then remove the first line of created file

wsdl2jolie http://localhost:8080/acme-agency-ws-0.0.1-SNAPSHOT/SellerWebService?WSDL > GeneratedInterface.iol
