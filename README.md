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

La rotta **getFilter** si occupa dell'operazione di filtraggio dei domini, in essa è stata implementata la possibilità di inserire contemporaneamente fino a **4 parametri di filtraggio** in input, grazie alla logica "AND". Il risultato finale sarà la restituzione di un HashSet composto dai domini filtrati secondo gli input inseriti.
C’è la possibilità che venga lanciata l’**eccezione “APIunreachable”** nel caso in cui uno o più parametri nella chiamata getFilter non restituiscano risultati, generando un HashSet dei domini filtrati vuoto.

#### Esempio di chiamata su POSTMAN
![getFilter](https://user-images.githubusercontent.com/77545538/105333697-4e511e00-5bd6-11eb-8f27-1aaa01178c75.png)

I parametri inseribili in input corrispondono a:
- **domain**: Filtraggio per stringa contenuta nel nome del dominio
- **create**: Filtraggio per il mese di creazione del dominio
- **update**: Filtraggio per substringa contenuta nella data dell'ultimo aggiornamento
- **hosting** : Filtraggio per nazione di hosting

### POST /filter

La rotta **postFilter** si occupa della stessa funzione della precedente rotta **getFilter** ed ha la possibilità che venga lanciata la stessa eccezione **“APIunreachable”**.
Essa lavora in modo diverso per quanto riguarda l'inserimento dei parametri(i quali restano **invariati**) di filtraggio in input, infatti verrà richiesto di inserire un **body** in formato JSON con la seguente forma:

![postFilter](https://user-images.githubusercontent.com/77545538/105337855-2a440b80-5bdb-11eb-85c0-0d49191f4455.png)

### GET /stats

La rotta **getStats**  ha la funzione di calcolare e generare le statistiche relative ad un HashSet di domini già filtrati secondo alcuni parametri, oppure a partire da un HashSet di domini non filtrati.
In ogni caso essa richiama la rotta **/filter** e di conseguenza c'è la possibiltà che venga lanciata l'eccezione **"APIunreachable"**.

#### Esempio di chiamata su POSTMAN (con filtro per HostingCountry)
![getstats1](https://user-images.githubusercontent.com/77545538/105339818-68422f00-5bdd-11eb-8f4c-8d3a4d68127f.png)
![getstats2](https://user-images.githubusercontent.com/77545538/105339835-6c6e4c80-5bdd-11eb-9522-18f728ae2118.png)

#### Riepilogo statistiche

- Nazione di Hosting: coincide con il numero di domini trovati per ciascuna nazione di hosting
- Quantità domini: numero effettivo di domini trovati dalla ricerca
- Parole Chiave : conteggio delle parole chiave più comuni
- Tempo medio di Update: Tempo medio dall'ultimo update espresso in giorni


### /error

La rotta **/error** è suddivisa in chiamate **GET** e in chiamate **POST**, essa si occupa della gestione di eccezioni dovute all'immissione di rotte non implementate nel software, ciò può accadare per via di errori di battitura.


------------

## ECCEZIONI

Ecco la lista delle **eccezioni personalizzate** inserite nell'applicazione:

### APInotworking

Questa eccezione viene lanciata dal momento in cui l'API non risponde correttamente alla chiamata poichè è offline o non funzionante. Ciò avviene quando si utilizza un **link base verificato** per richiedere ad esempio la lista di domini senza applicare filtri o generare statistiche e non viene restituito nulla.
Il messaggio restituito è:
`"L'API sembra non essere attualmente funzionante..."`

### APIunreachable

Come è stato esposto precedentemente, questa eccezione viene lanciata nell'ambito della chiamata **/filter**, nel caso in cui i parametri inseriti dovessero generare una **filteredList vuota**. Allo stesso tempo potrebbe verificarsi il fatto che sia l'API non funzionante a generare l'eccezione, quindi è consigliabile fare un tentativo con la rotta: **GET /domains** , allo scopo di controllare se **"APInotworking"** viene lanciata.

ESEMPIO DI ECCEZIONE
![eccezioneunreachable](https://user-images.githubusercontent.com/77545538/105343262-af322380-5be1-11eb-94a2-2c03df6de9cf.png)

### WrongRequest

Questa eccezione si riallaccia direttamente alla rotta **/error**, ovvero viene lanciata nel momento in cui vengono fatte delle richieste errate, relative a rotte non implementate nel software. Il messaggio restituito è:
`"Rotta non implementata!"`

ESEMPIO
![wrongrequest](https://user-images.githubusercontent.com/77545538/105343850-75ade800-5be2-11eb-8d0e-7da823f2da5f.png)


------------

## SEQUENCE DIAGRAM

Questo **diagramma UML** viene utilizzato per descrivere uno scenario, nel quale sono rappresentati gli oggetti(o entità) e i messaggi scambiati fra loro, seguendo un processo temporale ben definito. In questo caso ci sono tre diagrammi, uno per ciascuna delle **principali rotte** dell'applicazione.
*(La modellazione UML è stata ideata prima dell'effettiva programmazione in Java)*

#### /domains
![_Domains1](https://user-images.githubusercontent.com/77545538/105344507-52376d00-5be3-11eb-8d70-4d26c24e33aa.jpeg)

#### /filter
![_Filter](https://user-images.githubusercontent.com/77545538/105344521-56638a80-5be3-11eb-824a-79f842d08375.jpeg)

#### /stats
![_Stats](https://user-images.githubusercontent.com/77545538/105344493-4cda2280-5be3-11eb-8747-a3ef18580307.jpeg)


------------

## JUNIT TEST

Nell'applicazione è stata implementata una sezione di testing attraverso l'utilizzo di [JUNIT5](https://junit.org/junit5/ "JUNIT5").

1. **APITest**: Verifica restituzione HashSet non nullo dall'API.
1. **FilterTest**: Verifica di un particolare filtro, in questo caso controlla che il mese della data di creazione dei domini sia Giugno.
1. **StatsTest**: Verifica della generazione di statistica riguardo alla quantità di domini corretta.
1. **UnreachableTest**: Verifica il lancio dell'eccezione per filtri che non restituiscono valori.

------------

*Grazie per l'attenzione*

### **AUTORI**
|  Nome |
| ------------ |
| [Matteo Meloni](https://github.com/MatteoM2000 "Matteo Meloni") |
| [Alex Rinaldi](https://github.com/Alexito-00 "Alex Rinaldi")  |
