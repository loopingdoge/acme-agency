# Indice

- [Coreografia](#coreografia)
- [BPMN](#bpmn)
- [Servizi esterni](#servizi-esterni)
  - [Banca](#banca)
  - [Catasto](#catasto)
  - [Distanze](#distanze)
  - [Mail](#mail)
  - [Session manager](#session-manager)
- [Agenzia ACME](#agenzia-acme)
  - [Web service](#web-service)
  - [BPMS](#bpms)
- [Clients](#clients)
  - [Buyer](#buyer)
  - [Seller](#seller)

# Coreografie

- [Coreografia completa](/choreographies/choreography.md)
- [ACME](/choreographies/acme_role.md)
- [Acquirente](/choreographies/buyer_role.md)
- [Venditore](/choreographies/seller_role.md)
- [Banca](/choreographies/bank_role.md)
- [Catasto](/choreographies/cadastre_role.md)
- [Distanze](/choreographies/distance_role.md)

# [BPMN](https://github.com/MisterDev/ACME-agency/blob/master/bpmn)

# Servizi esterni

## [Banca](https://github.com/MisterDev/ACME-agency/blob/master/src/bank)

Come da specifiche, la banca è stata implementata in Jolie e comunica attraverso il protocollo SOAP.

Sono state implementate le operazioni di:
- login
- logout
- deposito di denaro
- ritiro di denaro
- pagamento
- richiesta di mutuo
- report

Non tutte queste operazioni sono usate nella coreografia

## [Catasto](https://github.com/MisterDev/ACME-agency/blob/master/src/cadastre)

## [Distanze](https://github.com/MisterDev/ACME-agency/blob/master/src/distance)

## [Mail](https://github.com/MisterDev/ACME-agency/blob/master/src/mail)

## [Session manager](https://github.com/MisterDev/ACME-agency/blob/master/src/camunda-session-manager)

# Agenzia ACME

## [Web service](https://github.com/MisterDev/ACME-agency/blob/master/src/acme-agency-ws)

## [BPMS](https://github.com/MisterDev/ACME-agency/blob/master/src/acme-agency)

# Clients

## [Buyer](https://github.com/MisterDev/ACME-agency/blob/master/src/java-buyer)

## [Seller](https://github.com/MisterDev/ACME-agency/blob/master/src/java-seller)