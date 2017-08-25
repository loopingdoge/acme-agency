#!/bin/bash

jolie2wsdl --namespace ex.sessions.jolie.it --portName SessionServer --portAddr http://localhost:8844 --o session_manager.wsdl session_manager.ol
