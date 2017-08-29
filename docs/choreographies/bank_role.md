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
    notifyPayment@b           // Notifica il ricevente
                              // (Acme o venditore)
  ) 
)*
```
