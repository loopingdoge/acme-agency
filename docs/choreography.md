# Choreography
[original](https://docs.google.com/document/d/1JD8ezlyFcMhfY2zxhvjHioae0P5xOWsV5lVo8JomOAA/edit#)

    a = acquirente
    v = venditore
    acme = agenzia
    bank = banca
    dist = distance service
    cada = cadastral coordinates service
    nota = notary
    (
        (
    request: a → acme;
            ( 
                (
            askDist: acme → dist; replyDist: dist → acme
        )*;
                proposal: acme → a; proposalReply: a → acme
            ) *;
            1 + (
                askAvail: acme → v; availReply: v → acme; 
                sendAvail: acme → a; meetReply: a → acme;
            1 + (
                    meetFinalProposal: acme → v; meetFinalReply: v → acme
                )
            );
            (
                meetDenies: acme → v | meetDenies: acme → a
            )
            + 
            (
                meetAgree: acme → v | meetAgree: acme → a;
                1 + (
                    1 + (
                        loanRequest: a → bank; loanReply: bank → a
                    );
                    1 + (
                        offer: a → acme; 
                        (
                            (
                                ( askCada: acme → cada; replyCada: cada → acme )
                                1 + ( 
                                    askCada: acme → cada; replyCada: cada → acme;
                                    1 + sendAgent: acme → cada
                                )
                            )
                            |
                    ( askDist: acme → dist; replyDist: dist → acme )
                        );
                        offer: acme → v;
                        (
                            denyOffer: v → acme
                        )
                        + 
       (
                    agreeOffer: v → acme;
                            agreeDeposit: a → bank; sendDeposit: bank → v; 
                            ( signContract: a → nota; signContract: v → nota );
                            agreePayment: a → bank; pay: bank → acme; pay: bank → v
                        )
                    )
                )
            )
        )
        | 
        (
            offer: v → acme
        )
    )