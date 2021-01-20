# OOP PROJECT: DOMAINS DB

### INTRODUZIONE ALL'APPLICAZIONE SPRINGBOOT
L'applicazione sviluppata nell'ambito di questo progetto, si prefigge lo scopo di implementare un sistema in grado di ottenere in Input e gestire alcune operazioni per i **domini commerciali (.com)** non più attivi , sfruttando l'**API Reference** [Domains-Index](https://api.domainsdb.info/v1/ "Domains-Index").
Si tratta di un'applicazione **Spring Boot**, progetto del **framework** [Spring](https://spring.io/ "Spring")  , grazie ad esso viene semplificato lo sviluppo, poiché effettua una configurazione automatica , sulla
base di valori di default.
### FUNZIONI E  UTILIZZO PRATICO
Le principali funzioni implementate in questo progetto corrispondono alla **generazione di statistiche** e all'**operazione di filtraggio**, le quali sono possibili contemporaneamente, relative ai Domini restituiti dalla REST API.
Una possibile finalità del progetto è quella di consentire ad un utente di accedere alle funzionalità implementate attraverso un Client come [Postman](https://www.postman.com// "Postman"), strumento per testare un'API REST in API Gateway.

------------

## UML USE CASE DIAGRAM

Questo **diagramma UML** raffigura la descrizione dei servizi offerti dal sistema, mettendo in evidenza le interazioni con dei possibili attori esterni.

![Use case](https://user-images.githubusercontent.com/77545538/105252503-d48d4600-5b7d-11eb-9442-da34f61269e7.jpg)

------------
## CLASS DIAGRAM

Questo **diagramma UML** consente di descrivere tipi di entità(classi) presenti nel programma, includendo le eventuali caratteristiche(attributi) e le relazioni fra loro.

![Class Diagram](https://user-images.githubusercontent.com/77545538/105253527-f5569b00-5b7f-11eb-85c8-3ebbfa7876cc.jpg)

------------

## SCHEMA RIEPILOGATIVO DELLE ROTTE

| TIPO  | ROTTA  |
| ------------ | ------------ |
| GET  | /domains  |
| GET  | /metadata  |
| GET  |  /stats |
|  GET | /filter   |
|POST   |  /filter |
|  GET | /error  |
|  POST | /error  |
