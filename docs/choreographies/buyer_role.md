# Acquirente

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
            agreeDeposit@bank;
            depositDone#bank;
            signContract@nota;
            contractDone#nota;
            agreePayment@bank
          )
        )
      )
    )
  )
)
```