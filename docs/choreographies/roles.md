### [**🏠 Home**](../README.md)

###  [**⬅️ Back**](choreography.md)
-----
# Coreografia proiettata sui ruoli

## Indice

- [Acme](#acme)
- [Acquirente](#acquirente)
- [Venditore](#venditore)
- [Banca](#banca)
- [Catasto](#catasto)
- [Distanze](#distanze)

## Notazione 
Si usa il simbolo *@* per l'invio di messaggi e *#* per la ricezione.

## Acme

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
        sendMeetingProposal@a;
        meetingProposalReply#a;
        
        1
          +
        (
          sendMeetingProposal@v;
          meetingProposalReply#v
        )
      );

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
              notifyPayment#bank
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
## Acquirente

```
(
  request@acme;                      // Effettua richiesta
  
  (
    (
      proposal#acme;                  // Riceve proposte case
      proposalReply@acme              // Risponde alla richiesta
    )*
  );

  (
    1                                 // Skip --- ha interrotto la richiesta di case
      +                               // oppure
    
    (
      sendMeetingProposal#acme;       // Risposta alle date di meeting del venditore
      meetingProposalReply@acme        
    );

    (
      meetDenied#acme                 // Skip --- incontro riufiutato
    )
      +
    (
      meetAgree#acme;                 // Incontro accettato
    
      (
        1                             // Skip --- no richiesta prestito
          +
        (
          loanRequest@bank;           // Richiesta prestito
          loanReply#bank
        )
      );

      (
        (
          noOffer@acme                // Rifiuta o nessuna offerta
        )
          +
        (
          offer@acme;                 // Offerta

          (
            vendorDeny#acme           // Ricevo un rifiuto del vendor
          )
            +

          (
            vendorAgree#acme;         // Il vendor ha accettato, finalizzo
            pay@bank;                 // Pagamento della caparra
            notifyPayment#bank;
            signContract@nota;
            contractDone#nota;
            pay@bank                  // Pagamento
          )
        )
      )
    )
  )
)
```
## Venditore

```
(
  (
    (
      askAvail#acme;                  // Riceve da Acme una richiesta di quando e' disponibile
      availReply@acme;                // dato che un acquirente e' interessato a una casa
    
      1                               // L'acquirente accetta
        +
      (
        sendMeetingProposal#acme;     // L'aquirente ha proposto nuove date
        meetingProposalReply@acme
      )
    );

    (
      meetDenied#acme                 // Skip --- incontro riufiutato
    )
      +
    (
      meetAgree#acme;                 // Incontro accettato

      (
        noOffer#acme                  // Dopo l'incontro non riceve offerte
      )
        +
      (
        offer#acme;                   // Riceve offerta

        (
          denyOffer@acme              // Rifiuta offerta
        )
          +
        (
          agreeOffer@acme;            // Accetta offerta
          sendDeposit#bank;
          signContract@nota;
          contractDone#nota;
          notifyPayment#bank
        )
      )
    )
  )
    |  
  (
    offer@acme                        // Propone casa all'agenzia
  )
)
```
## Banca

```
(
  (
    loanRequest#a;            // Richiesta di mutuo
    loanReply@a
  )
    |
  (
    pay#a;                    // Richiesta di effettuare un pagamento
    notifyPayment@a;

    1
    +
    notifyPayment@other       // Puo' notificare anche Acme o venditore
  ) 
)*
```
## Catasto

```
(
  askCada#acme;               // Riceve richiesta per coordinate
  replyCada#acme;             // Risponde alla richiesta, anche richiedendo correzioni
          
  (
    1                         // Skip --- la richiesta era corretta
      +
    (      
      askCada#acme;           // Riceve la richiesta aggiustata
      replyCada#acme;         // Risponde, anche richiedendo intervento dipendente

      (
        1                     // Skip --- la correzione era valida
          +
        sendAgent#acme        // Riceve il dipendente dell'agenzia
      )      
    )
  )
)*
```
## Distanze

```
(
  askDist#acme;           // Riceve richiesta di distanza
  replyDist@acme
)*
```
------
### [**➡️ Next**](../bpmn.md)
