# Banca

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
