### [**🏠 Home**](../README.md)

###  [**⬅️ Back**](../README.md)
-----
# Coreografia

```
(
  (
    request: a → acme;                                      // Richiesta dall'acquirente
    
    ( 
      ( askDist: acme → dist; replyDist: dist → acme )* ;   // Ciclo di proposta case
       proposal: acme → a; proposalReply: a → acme
    )*;

    1 
      +  
    ( 
      (
        askAvail: acme → v;                                 // Accordo sulla disponibilita'
        availReply: v → acme; 
        sendMeetingProposal: acme → a;
        meetingProposalReply: a → acme; 
        
        1
          +
        (
          sendMeetingProposal: acme → v;
          meetingProposalReply: v → acme
        )
      );
        
      (
        meetDenies: acme → v | meetDenies: acme → a         // No accordo, no incontro
      )
        + 
      (
        (
          meetAgree: acme → v | meetAgree → acme → a        // Incontro fatto
        );
                
        (
          (
            1                                               // Richiesta di prestito opzionale
              +  
            (
              loanRequest: a → bank; 
              loanReply: bank → a
            )
          );
                      
          (                                                 // No offerta dopo l'incontro
            noOffer: a → acme;                              // o dopo prestito rifiutato  
            noOffer: acme → v 
          )   
            + 
          (
            offer: a → acme;                                // Offerta
                            
            (
              (
                ( 
                  askCada: acme → cada;                     // Richiesta al catasto
                  replyCada: cada → acme    
                );
                                      
                1                                           // Ok
                  +                                         // oppure
                ( 
                  askCada: acme → cada;                     // Risistemo indirizzo
                  replyCada: cada → acme;
                                          
                  1                                         // Ok
                    +                                       // oppure
                  sendAgent: acme → cada                    // Invio personale
                )
              )
                |                                           // parallelamente
              ( 
                askDist: acme → dist;                       // Richiesta distanza notaio
                replyDist: dist → acme 
              )* ;                                          // Per ogni notaio in lista
            );
        
            offer: acme → v;                                // Proposta al venditore
      
            (
              (
                denyOffer: v → acme                         // Venditore rifiuta
                vendorDenied: acme → a
              )
                + 
              (
                agreeOffer: v → acme;                       // Venditore accetta
                vendorAgreed: acme → a;
                (
                	pay: a → bank;                          // Invia la caparra
                	confirmPayment: bank → a
                )*;
                notifyPayment: bank → v;
                                  
                ( 
                  signContract: a → nota | signContract: v → nota 
                );

                (
                	contractDone: nota → a
                	|
                	contractDone: nota → acme
                	|
                	contractDone: nota → v
                );

                (
                	pay: a → bank;                          // Pagamento ad acme
                	confirmPayment: bank → a
                )*;
                notifyPayment: bank → acme;
                
                (
                	pay: a -> bank;                         // Pagamento al venditore
                	confirmPayment: bank → a
                )*;
                notifyPayment: bank → v
              )
            )
          ) 
        )
      )
    )         
  ) 
    | 
  (
    offer: v → acme                                         // Offerta di casa dal venidtore
  )
)
```
## Coreografia in BPMN [(sources)](https://github.com/loopingdoge/acme-agency/tree/master/bpmn/choreographies)
Le coreografie BPMN delle istanze di processo avviate in risposta alle richieste di acquirente e venditore sono state realizzate usando Lucidachart come editor online.

## Analisi di Connectedness

La coreografia riportata sopra gode della proprietà di connectedness. Di seguito si effettua una analisi dettagliata per dimostrarlo:

* Le due funzioni principali di Acme, ossia la vendita di una casa e l’inserimento di una nuova casa, sono in parallelo e non richiedono quindi particolari condizioni

* L’iterazione della proposta di case a un acquirente non presenta problemi dato che le sequenze al suo interno sono del tipo *a→b ; b→a* e la condizione di terminazione è data dal contenuto di *proposalReply*

* La choice seguente dipende anch’essa dal contenuto di *proposalReply* e la decisione è presa da Acme

* La fase di accordo sulla data dell’incontro è corretta, dato che tutte le sequenze sono del tipo *a→b ; b→c*

* La choice per l’esito dell’accordo sull’incontro è ok, in quanto la decisione è presa da Acme e entrambi i rami coinvolgono gli stessi ruoli (che saranno in attesa su *meetAgree* e *meetDenies*)

* La choice seguente è corretta, dato che la decisione coinvolge solamente l’acquirente e la banca è sempre in attesa per una *loanRequest*

* La choice per una eventuale offerta è ok, in quanto la decisione è presa dall’acquirente e entrambi i rami coinvolgono gli stessi ruoli (che saranno in attesa su *offer* e *noOffer*) e anche il venditore viene informato sull’esito

* Le choice riguardanti il catasto sono corrette, dato che le decisioni sono prese da Acme in base al contenuto di *replyCada*

* La choice riguardo l’esito dell’offerta coinvolge gli stessi attori come primo messaggio di entrambi i rami, e in seguito entrambi informano l’acquirente

* La fase di invio della caparra è corretta, dato che tutte le sequenze sono del tipo *a→b ; b→c*

* Potenziale problema di connectedness tra la firma del contratto e il successivo pagamento, anche se in un contesto concreto l’azione in parallelo (ossia la firma del contratto da parte di acquirente e venditore) avviene contemporaneamente. Si aggiunge una *contractDone* per evitare ciò.


-----
### [**➡️ Next**](roles.md)
