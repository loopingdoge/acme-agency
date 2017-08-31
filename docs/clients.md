### [**🏠 Home**](/README.md)

###  [**⬅️ Back**](acme-agency.md)
-----
# Clients

Entrambi i client sono realizzati con programmi Java e, seppur con interfaccia utente elementare, permettono di realizzare
tutte le operazioni ad essi richieste.

Si interfacciano con Acme tramite i web service esposti dall'agenzia e, nel caso dell'acquirente, anche con quello della banca.
Il codice che effettua le richieste ai servizi è generato automaticamente tramite `wsimport`, a partire dai WSDL dei servizi
necesssari (vedasi i file `generate_ws.bat` e `generate_ws.bat` nella root directory del progetto).

I client sono stati realizzati in modo tale da non esporre servizi, quindi si utilizza il servizio di 
[Mail](/external_services.md) per inviare ad essi notifiche. 

Inoltre utilizzano il servizio delle [Sessioni](/external_services.md) per continuare istanze di processo
anche in esecuzioni differenti.

## [Buyer](https://github.com/MisterDev/ACME-agency/blob/master/src/java-buyer)

Implementa le seguenti operazioni:

* **House lookup**: richiesta di una casa da poter acquistare, specificando un profilo di interesse

* **House proposal reply**: azione che effettua in seguito ad aver ricevuto una possibile lista di case, fra chiederne altre,
accettarne una di quelle proposte o interrompere la ricerca

* **Reply to meeting proposal**: accettare una data proposta dal venditore per incontrarsi, oppure proporne di nuove

* **Make offer**: effettuare un'offerta per una casa di interesse

* **Loan request**: richiesta di prestito alla banca

* **Pay**: pagamento a un venditore o ad Acme, tramite la banca

## [Seller](https://github.com/MisterDev/ACME-agency/blob/master/src/java-seller)

Implementa le seguenti operazioni:

* **House proposal**: richiesta di aggiunta di una nuova casa in vendita

* **Send availability**: invio delle date possibili per un incontro con l'acquirente

* **Confirm meeting**: accettazione o rifiuto di una delle date per l'incontro proposte dall'acquirente

* **Get offer**: richiesta delle informazioni riguardo un'offerta ricevuta per una casa

* **Offer reply**: accettazione o rifiuto di un'offerta ricevuta per una casa
