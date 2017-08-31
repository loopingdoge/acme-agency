# Indice

- [Coreografia completa](choreographies/choreography.md)
- [Coreografia proiettata sui ruoli](choreographies/roles.md)
  - [ACME](choreographies/roles.md#acme)
  - [Acquirente](choreographies/roles.md#acquirente)
  - [Venditore](choreographies/roles.md#venditore)
  - [Banca](choreographies/roles.md#banca)
  - [Catasto](choreographies/roles.md#catasto)
  - [Distanze](choreographies/roles.md#distanze)
- [BPMN](bpmn.md)
- [Servizi esterni](external-services.md)
  - [Banca](external-services.md#banca)
  - [Catasto](external-services.md#catasto)
  - [Distanze](external-services.md#distanze)
  - [Mail](external-services.md#mail)
  - [Session manager](external-services.md#session-manager)
- [Agenzia ACME](acme-agency.md)
  - [Web services](acme-agency.md#web-services)
  - [BPMS](acme-agency.md#bpms)
- [Clients](clients.md)
  - [Buyer](clients.md#buyer)
  - [Seller](clients.md#seller)

# Componenti del gruppo

| Nome              | Matricola | Email                             |
| ----------------- | --------- | --------------------------------- |
| Alberto Nicoletti | 819697    | alberto.nicoletti@studio.unibo.it |
| Devid Farinelli   | 819683    | devid.farinelli@studio.unibo.it   |
| Filippo Morselli  | 819508    | filippo.morselli@studio.unibo.it  |

# Introduzione

Nel progetto sono state implementate tutte le richieste obbligatorie della consegna ela coreografia BPMN opzionale.

Nella realizzazione del progetto sono stati utilizzati i seguenti linguaggi e tool:

- **Camunda modeler** per la modellazione del diagramma di collaborazione BPMN;
- **Lucidchart** per la modellazione del diagramma di coreografia BPMN;
- **Jolie** e **Java** per i servizi SOAP;
- **Node.js** per i servizi REST.

## Esecuzione

Per eseguire il progetto, avviare:

- il server Wildfly fornito, già configurato per l'esecuzione, tramite lo script `start_camunda`;
- lo script `start_services` contenuto nella *root* del progetto;
- `java-buyer.jar`,  `java-seller.jar` ed eseguire le istruzioni a riga di comando;
- Aprire con un browser [questo](http://localhost:8080/camunda/app/welcome/default/#/welcome) indirizzo, loggare usando `john` come *username* e *password*, ed aprire la tasklist, effettuando gli user task quando necessario.



------
### [**➡️ Next**](choreographies/choreography.md)