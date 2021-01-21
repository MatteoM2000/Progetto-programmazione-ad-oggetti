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

### GET /Domains

La rotta **getDomains** ha il compito fondamentale di comunicare con l'API attraverso un URL Verificato e restituire all'applicazione la lista dei domini commerciali non più attivi, i quali vengono inseriti in un HashSet chiamato **"domainList"**.
C'è la possibilità che venga lanciata l'**eccezione "APInotworking"** nel caso in cui non vengano restituiti i domini attesi.

#### Esempio di chiamata su POSTMAN
![getDomains](https://user-images.githubusercontent.com/77545538/105328548-70e03880-5bd0-11eb-8797-49fc0016c3b1.png)

Il risultato riportato è in formato JSON e ciascun dominio è descritto dai seguenti campi:
- **domain**: Nome del dominio
- **createDate**: Data di creazione del dominio
- **updateDate**: Data dell'ultimo aggiornamento
- **country** : Nazione di hosting
- **isDead** : Attività o inattività del dominio (scadenza)

### GET /metadata

La rotta **getMetadata**, come suggerito dal nome restituisce i metadati relativi al modello di ciascun dominio in JSON, essi coincidono con il tipo di dato per ciascun campo.

#### Esempio di chiamata su POSTMAN
![getMetadata](https://user-images.githubusercontent.com/77545538/105330847-0da3d580-5bd3-11eb-8345-8124eb464f8f.png)

### GET /filter

La rotta **getFilter** si occupa dell'operazione di filtraggio dei domini, in essa è stata implementata la possibilità di inserire contemporaneamente fino a **4 parametri di filtraggio** in input, grazie alla logica "And". Il risultato finale sarà la restituzione di un HashSet composto dai domini filtrati secondo gli input inseriti.
C’è la possibilità che venga lanciata l’**eccezione “APIunreachable”** nel caso in cui uno o più parametri nella chiamata getFilter non restituiscano risultati, generando un HashSet dei domini filtrati vuoto.

#### Esempio di chiamata su POSTMAN
![getFilter](https://user-images.githubusercontent.com/77545538/105333697-4e511e00-5bd6-11eb-8f27-1aaa01178c75.png)

I parametri inseribili in input corrispondono a:
- **domain**: Filtraggio per stringa contenuta nel nome del dominio
- **createDate**: Filtraggio per il mese di creazione del dominio
- **updateDate**: Filtraggio per substringa contenuta nella data dell'ultimo aggiornamento
- **country** : Filtraggio per nazione di hosting

### POST /filter
