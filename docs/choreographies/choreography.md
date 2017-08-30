### [**🏠 Home**](/README.md)

###  [**⬅️ Back**](/README.md)
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
                pay: a → bank;                              // Invia la caparra
                notifyPayment: bank → a; 
                                  
                ( 
                  signContract: a → nota | signContract: v → nota 
                );
                      
                ( contractDone: nota → a | contractDone: nota → v );
                                
                pay: a → bank;                              // Pagamento
                notifyPayment: bank → acme; 
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
## Connectedness

-----
### [**➡️ Next**](roles.md)