package univpm.progettoOOP;

import java.util.HashSet;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.DisplayName;


import univpm.progettoOOP.exception.APIunreachable;
import univpm.progettoOOP.filters.Filter;
import univpm.progettoOOP.filters.byCreationDate;
import univpm.progettoOOP.model.Domain;
import univpm.progettoOOP.service.DomainService;
import univpm.progettoOOP.service.DownloadJSON;
import univpm.progettoOOP.service.ServiceImplementation;
import univpm.progettoOOP.stats.Quantity;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * Classe UnitTest del programma
 * @author  Meloni Matteo
 * @author  Alex Rinaldi
 * @version 1.0.0
 */

@SpringBootTest
class ProgettoOopApplicationTests {

 	/**
 	 * HashSet dei domini restituiti
 	 */
	
	private HashSet<Domain> domainList = null;
 	
 	/**
 	 * HashSet dei domini filtrati
 	 */
	
	private HashSet<Domain> filteredList = null;
 	
 	/**
 	 * URL per la chiamata all'API funzionante
 	 */
	
	static final String workingurl = "https://api.domainsdb.info/v1/domains/search?limit=50&zone=com&isDead=true";
 	
 	/**
 	 * Oggetto per la gestione chiamate
 	 */
	
	DomainService ds = new ServiceImplementation();
 	
 	/**
 	 * Oggetto che restituisce l'HashSet dei domini ottenuti dall'API
 	 */
	
	DownloadJSON dj = new DownloadJSON(workingurl);
 	
 	/**
 	 * Oggetto della statistica di tipo Quantity
 	 */
	
	Quantity quantity;
 	
 	/**
 	 * Inizializzazione oggetti utili per i Test
 	 * @throws Exception se si verificano eccezioni
 	 */
	@BeforeEach
	void setUp() throws Exception
	{   
 		
 		domainList = dj.APIcall();
 		
 		Filter f = new byCreationDate(domainList);
 		
 		filteredList = f.toFilter("06");
 		
 		quantity = new Quantity(domainList);
 		
 		quantity.calculateStat();
 		
 		
 		}
 	
 	@AfterEach
	void tearDown() throws Exception{}
 	
	/**
	 * Primo test:  Verifica restituzione HashSet non nullo dall'API
	 */
 	@Test
	@DisplayName("Test1 : Verifica restituzione HashSet non nullo dall'API")
	void apiTest() {
		assertNotNull(domainList);
	}
	
	/**
	 * Secondo test: Verifica che il mese della data di creazione dei domini sia Giugno
	 */
 	@Test
	@DisplayName("Test2 : Verifica che il mese della data di creazione dei domini sia: 06")
	void filterTest() {
		String s;
		
		for(Domain d : filteredList) {
			s =d.getCreateDate().substring(5, 7);
			assertEquals(s ,"06");
		}
	}
	
 	/**
 	 * Terzo test: Verifica che la quantità di domini sia corretta
 	 */
	@Test
	@DisplayName("Test3 : Verifica che la quantità di domini sia corretta")
	void statsTest() {
		
		assertTrue (domainList.size() == quantity.getQuantity());
	}
	
	/**
	 * Quarto test: Verifica il lancio dell'eccezione per filtri che non restituiscono valori
	 */
	@Test
	@DisplayName("Test4 : Verifica il lancio dell'eccezione per filtri che non restituiscono valori")
	void unreachableTest() {
		try {
			ds.getFilter("data", "IT", "hello", "world");
			fail("Eccezione non lanciata");
			} catch (APIunreachable e) {}
	}
	
	
		
	}

