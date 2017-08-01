#!/bin/bash

# Generate WSDL file for a Jolie web service

# SYNTAX:
# jolie2wsdl [ -i include_file_path ] --namespace [target_name_space]
# --portName [name_of_the_port] --portAddr [address_string]
# --o [output_filename] filename.ol

jolie2wsdl --namespace ex.example.it --portName ServiceForJava --portAddr http://localhost:8000 --o serviceforjava.wsdl server.ol
