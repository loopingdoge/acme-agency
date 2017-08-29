#!/bin/bash

jolie2wsdl --namespace org.loopingdoge.acme.jolie.bank --portName BankService --portAddr http://localhost:7777 --o bank.wsdl server.ol;

