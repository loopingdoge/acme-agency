### [**🏠 Home**](/README.md)

###  [**⬅️ Back**](/bpmn.md)
-----
# Servizi esterni

Vengono in seguito presentate le peculiarità dei servizi esterni ad acme che sono stati realizzati per implementare la coreografia. Per maggiori informazioni su ognuno rimandiamo alle relative pagine Github (raggiungibili dai link presenti sui titoli) in cui sono descritte più approfonditamente le richieste possibili, i loro tipi, e le modalità di esecuzione.

## <a name="banca"></a> Banca [(sources)](https://github.com/loopingdoge/acme-agency/blob/master/src/bank)

Come da specifiche, la banca è stata implementata in Jolie e comunica attraverso il protocollo SOAP.

Sono state implementate le operazioni di:
- `login`
- `logout`
- `deposito di denaro`
- `ritiro di denaro`
- `pagamento`
- `richiesta di mutuo`
- `report`

Non tutte queste operazioni sono usate nella coreografia.

Prima di effettuare una qualsiasi operazione, il servizio della banca richiede in primo luogo di effettuare una operazione di `login`, che restituirà un `sid` da inviare tra i parametri delle chiamate successive. Per implementare questa sessione sono state usati **correlation set** nativi di Jolie.

Per rispettare la coreografia in seguito ad un'operazione di pagamento, la banca invia una mail al destinatario del pagamento attraverso il servizio delle mail.

## <a name="catasto"></a> Catasto [(sources)](https://github.com/loopingdoge/acme-agency/blob/master/src/cadastre)
Il catasto è un semplice servizio Jolie che dispone di una singola operazione `cadastrialCoordinates`, che, data una stringa in formato CSV così composta: `road;civic;city;cap;province;state`, restituisce le coordinate catastali (per semplicità calcolate come interi random tra 1 e 10000).

Un esempio del formato della risposta è il seguente:

```xml
<coordinates>
    <nord xsi:type="xsd:string">0</nord>
    <east xsi:type="xsd:string">0</east>
</coordinates>
<error xsi:type="xsd:string">Incorrect address format</error>
```

Infatti, essendo il catasto molto esigente sul formato dell'indirizzo, qualora questo non rispetti il formato richiesto, le coordinate verranno settate a 0 e verrà specificato un messaggio di errore.

## <a name="distanze"></a> Distanze [(sources)](https://github.com/loopingdoge/acme-agency/blob/master/src/distance)

Il servizio delle distanze è stato realizzato come servizio REST in Node.js ed opera con indirizzi reali utilizzando le API di [Google Distance Matrix](https://developers.google.com/maps/documentation/distance-matrix/).

Il servizio prevede due parametri GET, l'indirizzo di partenza e quello di arrivo, e restituisce una risposta così formata con un HTTP status code 200:

```json
{
  "message": "A message describing the result",
  "distance": "The distance from origin to destination in meters"
}
```

Nel caso ci fossero dei problemi con gli indirizzi, viene resituito un HTTP status code 400 ed una risposta vuota.

## <a name="mail"></a> Mail [(sources)](https://github.com/loopingdoge/acme-agency/blob/master/src/mail)

Questo servizio non era richiesto dalle specifiche, ma lo abbiamo realizzato per utilizzarlo come metodo di comunicazione generico nei casi in cui un'alternativa più specifica, come un web service, non ci sembrasse necessaria.

Ad esempio, nel subprocess di meeting agreement, non ci sembrava realistico che i messaggi verso buyer e seller avvenissero tramite SOAP (che avviene invece per le loro risposte), quindi abbiamo scelto di inviare i messaggi attraverso questo servizio.

![Meeting agreement subprocess BPMN](/images/meeting.png)

Il servizio delle mail è realizzato in REST tramite Node.js ed espone una risorsa `/{username}`, verso la quale è possibile fare richieste:

- **GET**, per ottenere la lista delle mail ricevute da tale utente
- **POST**, per inviare una mail a tale utente

Per ulteriori informazioni sull'interfaccia e le operazioni consigliamo di consultare il file [swagger.json](https://github.com/loopingdoge/acme-agency/blob/master/src/mail/swagger.json) attraverso l'[editor di swagger](https://editor.swagger.io/), con il quale è possibile anche provare le richieste.

## <a name="session-manager"></a> Sessioni [(sources)](https://github.com/loopingdoge/acme-agency/blob/master/src/camunda-session-manager)

Servizio che tiene traccia di tutte le istanze di processo attive. Esso permette ai client (acquirente 
e venditore) di interrogarlo allo scopo di recuperare le informazioni riguardo le proprie sessioni in corso.
Ad essi vengono infatti restituiti gli ID di istanze di processo in cui ci si aspetta una loro azione per
poter completare il successivo task. Il client, dopo aver scelto quale istanza continuare, utilizza il
*processId* corrispondente come parametro per le comunicazioni al web service di Acme.

I dati sulle sessioni sono invece inseriti e rimossi dall'agenzia Acme.

Il servizio espone pertanto due interfacce distinte, ed è realizzato in Jolie.

Fanno da eccezione a questa separazione le operazioni di *informDepositDone* e *informPaymentDone*, che permettono a 
un client di modificare il proprio stato nel processo notificando direttamente questo servizio. 
Il motivo di questa scelta è dato dal fatto che Acme non è coinvolta direttamente nella gestione delle caparre e del 
pagamento al venditore, pertanto non sarebbe in grado di aggiornare lo stato dell'acquirente in modo opportuno,
se non a fase di pagamento terminata.

------
### [**➡️ Next**](acme-agency.md)
