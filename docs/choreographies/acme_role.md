# Agenzia ACME

```
(
  (
    request#a;                      // Richiesta da un acquirente
    
    ( 
      askDist@dist;                 // Richiesta al servizio delle distanza
      replyDist#dist;
      proposal@a;                   // e propone possibili case d'interesse
      proposalReply#a
    )* ;  

    1                               // Skip --- la reply era una interruzione
      +
    (
      (
        askAvail@v;                 // Richiesta disponibilità
        availReply#v; 
        sendAvail@a;  
        meetReply#a
      ) *;

      (
        meetDenies@a                // Non incontro
          |
        meetDenies@v
      )
        +
      (
        (
          meetAgree@a               // Incontro
            |
          meetAgree@v
        );

        (
          noOffer#a;                // Dopo l'incontro nessuna offerta da a
          noOffer@v                 // Lo comunica anche a v
        )
          +
        (
          offer#a;                  // Offerta da a
        
          (
            (
              (
                askCada@cada;       // Richiesta coordinate
                replyCada#cada
              );
            
              1                     // Skip --- era nel formato corretto
                +
              (
                askCada@cada;
                replyCada#cada;
      
                1                   // Skip --- correzione accettata
                  +
                sendAgent@cada      // Invia dipendente
              )
            )
              |
            (
              askDist@dist;         // Richiede distanza notaio
              replyDist#dist
            )
          );
        
          offer@v;                  // Proposta al venditore
        
          (
            (
              denyOffer#v;          // Venditore rifiuta
              vendorDenied@a        // Si informa l'acquirente
            )
              +
            (
              agreeOffer#v;         // Venditore accetta
              vendorAgreed@a;
              pay#bank
            )
          )

        )
      )

    )

  )
    |
  (
    offer#v                         // Offerta da un venditore
  )
)*
```
