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

Nel progetto sono state implementate tutte le richieste obbligatorie della consegna e la coreografia BPMN opzionale.

Nella realizzazione del progetto sono stati utilizzati i seguenti linguaggi e tool:

- **Camunda modeler** per la modellazione del diagramma di collaborazione BPMN;
- **Lucidchart** per la modellazione del diagramma di coreografia BPMN;
- **Camunda Wildfly** server;
- **Jolie** e **Java** per i servizi SOAP;
- **Maven** per la gestione dei progetti Java;
- **Node.js** per i servizi REST;
- **Eclipse** o **IntelliJ Idea** per compilare i progetti Java.

## Scripts

Dentro la cartella `scripts` sono presenti anche gli script da eseguire prima di compilare alcuni progetti Java:

- `ext_wsdl2java`, per generare le classi Java a partire dai wsdl dei servizi esterni;
- `ws_wsdl2java`, per generare le classi Java a partire dai wsdl esposti dal web service attivo su Wildfly (il web service deve essere attivo).

## Esecuzione

Per eseguire il progetto:

1. Aprire il progetto `acme-model` con un IDE e compilarlo, eseguire il seguente comando per aggiungere il .jar generato nella repository Maven locale:

  ```shell
  $ mvn install:install-file
      -Dfile=<path to acme-model.jar>
      -DgroupId=org.loopingdoge.acme.model
      -DartifactId=acme-model
      -Dversion=1.0.0
      -Dpackaging=jar
      -DgeneratePom=true
  ```

2. Avviare il server Wildfly;

3. Da terminale andare nella cartella `wildfly-10.1.0.Final/bin` del server Wildfly, eseguire lo script `jboss-cli.sh`, fare `connect` ed eseguire il seguente comando `module add —name=org.loopingdoge.acme.model —resources=<path to acme-model.jar>` per aggiungere `acme-model` come modulo del server;

4. Aprire con un IDE il progetto `acme-agency-ws`, compilare il progetto e mettere il file .war generato nella cartella `wildfly-10.1.0.Final\standalone\deployments` del server Wildfly;

5. Eseguire gli script `scripts/ws_wsdl2java` e `scripts/ext_wsdl2java`;

6. Installare le dipendenze dei progetti **Node.js** tramite `npm install` nella directory dei progetti (`src/distance` e `src/mail`);

7. Definire una variabile d'ambiente di nome `MAPS_API_KEY` dando come valore una chiave da generare a [questo](https://developers.google.com/maps/documentation/distance-matrix/) indirizzo;

8. Eseguire `scripts/start_services` per avviare i servizi esterni;

9. Aprire con un IDE il progetto `acme-agency`, compilare il progetto e mettere il file .war generato nella cartella `wildfly-10.1.0.Final\standalone\deployments` del server Wildfly;

10. Aprire con Eclipse i progetti `src/java-buyer` e `src/java-seller`, ed eseguire le istruzioni a riga di comando;

11. Aprire con un browser [questo](http://localhost:8080/camunda/app/welcome/default/#/welcome) indirizzo, loggare usando `john` come *username* e *password*, ed aprire la tasklist, effettuando gli user task quando necessario.

------
### [**➡️ Next**](choreographies/choreography.md)
