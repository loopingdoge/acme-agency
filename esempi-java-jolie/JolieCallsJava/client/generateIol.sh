#!/bin/bash

# Generate Jolie interface from WSDL file

# Then remove the first line of created file

wsdl2jolie http://localhost:8080/jolie-calls-java-0.0.1-SNAPSHOT/HelloService?WSDL > GeneratedInterface.iol
