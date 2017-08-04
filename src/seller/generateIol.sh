#!/bin/bash

# Generate Jolie interface from WSDL file

# Then remove the first line of created file

wsdl2jolie http://localhost:8080/acmeagency-0.1/SellerWebService?WSDL > GeneratedInterface.iol
