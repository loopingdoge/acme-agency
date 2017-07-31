# Servizi

## ACME

### Compratore (1)

| Input                                    | Output                         |
| ---------------------------------------- | ------------------------------ |
| range metratura: **Range<integer>**      | lista di case: **List<House>** |
| range costo: **Range<float>**            |                                |
| massima distanza da un certo indirizzo: **integer** |                                |
| optionals: **Optionals**                 |                                |

### Compratore (2)

| Input                  | Output                              |
| ---------------------- | ----------------------------------- |
| casa scelta: **House** | contatto del venditore: **Contact** |

### Venditore

| Input                         | Output                |
| ----------------------------- | --------------------- |
| profilo della casa: **House** | conferma: **boolean** |
| indirizzo: **string**         |                       |
| optionals: **Optionals**      |                       |


## Banca

### Mutuo

| Input                            | Output                |
| -------------------------------- | --------------------- |
| profilo del cliente: **Contact** | conferma: **boolean** |

### Pagamento

| Input                         | Output                |
| ----------------------------- | --------------------- |
| somma di denaro: **float**    | conferma: **boolean** |
| IBAN destinatario: **string** |                       |


## Catasto
| Input                                    | Output                                   |
| ---------------------------------------- | ---------------------------------------- |
| indirizzo completo della casa: **CompleteAddress** | coordinate catastali: **CadastralCoordinates** |


## Distanze geografiche

| Input                   | Output                                   |
| ----------------------- | ---------------------------------------- |
| indirizzo 1: **string** | Distanza tra i due indirizzi: **integer** |
| indirizzo 2: **string** |                                          |

# Tipi

## Range<T>

- start: **T**
- end: **T**

## House

- address: **string**
- optionals: **Optionals**

## Optionals

- giardino: **boolean**
- ...

## Contact

- name: **string**
- lastname: **string**
- address: **string**
- phone: **string**

## CompleteAddress

- road: **string**
- civic: **string**
- city: **string**
- province: **string**
- CAP: **string**

## CadastralCoordinates

- lol: **string**
- wut: **string**

