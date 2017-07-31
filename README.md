# ACME-agency
Software Engineering Project 16/17 University of Bologna

Progetto Ingegneria del Software Orientata ai Servizi
A.A. 2016/2017

Descrizione del dominio e del problema

L’agenzia ACME fornisce servizi immobiliari ai propri clienti, fra i quali l’intermediazione per l’acquisto di immobili.
La tipica coreografia per l’acquisto si svolge come segue.
Un potenziale acquirente contatta l'agenzia immobiliare per acquistare una casa, specificando un profilo di abilitazione desiderato. Tale profilo contiene informazioni quali la metratura (da-a), il costo (da-a), la massima distanza da un certo indirizzo (es: entro 10 chilometri da Piazza Maggiore), la presenza o meno di giardino, eccetera.
Parallelamente potenziali venditori contattano l’agenzia per proporre abitazioni di cui forniscono un profilo in modo da creare delle offerte.
Sulla base del profilo specificato del potenziale acquirente e delle offerte registrate dai clienti venditori, l’agenzia propone al primo un certo numero di possibili case, iterando la procedura fino a che il cliente non decide di interrompere o fino a quando il cliente non trova una casa di suo gradimento. In quest'ultimo caso, l'agenzia, il potenziale acquirente e il venditore scelgono un giorno in cui incontrarsi per visionare la casa. Se la casa è di interesse del potenziale acquirente questo può decidere di fare un'offerta al venditore.
Nel caso in cui il cliente decida di usufruire di un mutuo, l’offerta verrà effettuata solo dopo che la banca, contattata dal cliente, abbia valutato la posizione del cliente e deciso se concedere il mutuo o meno.
L'offerta al venditore viene fatta necessariamente tramite l'agenzia. Nel momento in cui arriva un’offerta, in previsione di una potenziale finalizzazione della vendita, ACME contatta i servizi del catasto per ottenere le coordinate catastali dell’immobile dato l’indirizzo. E’ da notare che tale servizio è molto rigoroso sul formato dell’indirizzo e può capitare che quello fornito dal cliente non sia utilizzabile (mancanza di indicazione del civico, del CAP, indicazione di via o piazza, e così via); in caso il servizio non riesca ad identificare le coordinate viene richiesto l’intervento di un addetto dell’agenzia per modificare opportunamente i dati forniti dal venditore; se nemmeno dopo questa modifica il servizio è in grado di trovare le coordinate un addetto dell’agenzia si reca di persona al catasto.
Contemporaneamente al recupero delle coordinate catastali ACME contatta un servizio per il calcolo delle distanze geografiche per identificare a quale notaio rivolgersi (fra i due operanti in zona), scegliendo quello più vicino all’indirizzo dell’immobile in vendita. A questo punto ACME si mette in attesa di una risposta dal venditore. Se tale risposta non perviene nel giro di tre giorni la proposta si intende tacitamente respinta.
Se l'offerta viene accolta dal venditore, la banca, su autorizzazione dell’acquirente, invia la caparra al venditore. Dopodichè cliente e venditore firmano il contratto presso un notaio. Infine il cliente, tramite la banca, paga venditore e agenzia.
Workflow

Si modellino le comunicazioni dello scenario sopra esposto usando una coreografia, si discutano le sue proprietà di connectedness ed eventualmente si raffini la coreografia per migliorare tali proprietà. Si proietti la coreografia in un sistema di ruoli.
Utilizzando uno o più diagrammi di collaborazione BPMN si modelli l’intera realtà descritta compresi i dettagli di ogni partecipante (usando il processo del ruolo corrispondente come guida). Tale modellazione ha scopo documentativo quindi il livello di dettaglio deve essere consistente con tale scopo.
Si realizzi il sistema usando come tecnologie un BPMS (si consiglia di utilizzare Camunda), Jolie e API Rest, coi seguenti vincoli:
il sistema deve utilizzare il BPMS (almeno) per la parte di human workflow di ACME;
il sistema integra sotto forma di servizi esterni ad ACME (almeno) le seguenti capability: calcolo distanze geografiche, sistema bancario, servizi catastali;
i servizi di cui sopra vanno implementati (con logica elementare) come parte del progetto;
il sistema bancario deve essere realizzato in Jolie;
almeno un servizio va realizzato con API Rest.
I modelli di processo BPMN da utilizzare per il BPMS devono essere consistenti con la modellazione a scopo documentativo precedentemente realizzata; volendo si può anche scegliere di dettagliare compiutamente già dal primo modello le pool eseguibili. Quindi nel primo caso si avrebbe un primo modello BPMN documentativo e poi tanti modelli BPMN eseguibili quanti i partecipanti realizzati attraverso BPMS; in alternativa si avrebbe un unico modello BPMN con le pool eseguibili completamente dettagliate e gli altri partecipanti dettagliati a livello documentativo.
Il dialogo fra Jolie e BPMS deve avvenire via SOAP, si veda il sito del corso alla pagina delle risorse per informazioni ulteriori.
Consegna e discussione

Gruppi: il progetto va realizzato in gruppi di 2/3 persone.
Tempi: Il progetto va consegnato prima che inizino le lezioni dell’A.A. 2017-18.

Materiale da consegnare: relazione che descrive il lavoro fatto nelle varie fasi di modellazione e sviluppo, inclusi i vari diagrammi prodotti: coreografia e sistema proiettato, diagramma/i di processo BPMN, export del progetto del BPMS, sorgenti dei servizi Jolie ed eventuali sorgenti aggiuntivi.

Modalità  di consegna: via email con allegati. Se la dimensione degli allegati fosse eccessiva si consiglia di utilizzare servizi quali wetransfer, dropbox o similari.

Discussione del progetto: la discussione avviene su richiesta. Alla discussione devono presenziare tutti i membri del gruppo. La valutazione è personale, il che vuol dire che i partecipanti di uno stesso gruppo possono ottenere voti differenti fra loro. Queste specifiche non possono considerarsi definitive e verranno corrette e/o integrate quando necessario.
Opzioni

Fermo restando che la corretta realizzazione del progetto proposto senza le parti opzionali permette di ottenere comunque il massimo punteggio vengono proposte due consegne aggiuntive:
- Modellazione della coreografia anche attraverso un diagramma di coreografia BPMN.
- Descrizione dell’intero sistema come SOA utilizzando UML con profilo TinySOA.

# Course Resources
[SOSENG 16/17](http://soseng.web.cs.unibo.it/?page_id=762)

# Development Setup

- Camunda Wildfly distribution: https://camunda.org/download/
- Camunda modeler: https://camunda.org/download/modeler/
- Papyrus: https://eclipse.org/papyrus/
- Jolie: http://www.jolie-lang.org/downloads.html
