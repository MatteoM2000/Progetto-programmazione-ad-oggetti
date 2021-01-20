package univpm.progettoOOP.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import univpm.progettoOOP.exception.APInotworking;
import univpm.progettoOOP.exception.APIunreachable;
import univpm.progettoOOP.exception.wrongRequest;
import univpm.progettoOOP.service.*;

/**
 * Classe che gestisce le chiamate Get e Post implementate
 * @author Matteo Meloni
 * @author Alex Rinaldi
 * @version 1.0.0
 *
 */
@RestController
public class appController {
	
	/**
	 * Oggetto che contiene i metodi per le varie rotte dell'applicazione
	 * @see DomainService
	 */
	@Autowired
	DomainService ds;

	
	
	/**
	 * Rotta che restituisce domini commmerciali non più attivi
	 * @return HashSet di domini
	 * @throws APInotworking se l'API non restituisce domini con un URL standard verificato
	 * @see serviceImplementation#getDomains()
	 */
	@GetMapping("/domains")
		public ResponseEntity<Object> getDomains() throws APInotworking{		
		return new ResponseEntity<>(ds.getDomains(), HttpStatus.OK);
		
		
	}
	
	
	
	/**
	 * Rotta che restituisce i metadati dell'API
	 * @return Domain con i metadati dell'API
	 * @see serviceImplementation#getMetadata()
	 */
	@GetMapping("/metadata")
		public ResponseEntity<Object> getMetadata(){
		return new ResponseEntity<>(ds.getMetadata(), HttpStatus.OK);
	}
	
	
	
	/**
	 * Rotta che permette di filtrare i domini secondo parametri forniti in input
	 * @param domain Testo che dovrà essere contenuto nel nome del dominio
	 * @param hosting Paese di hosting
	 * @param update Substring che dovrà essere presente nella data di update
	 * @param create Mese dell'anno in cui il dominio è stato creato
	 * @return HashSet di domini filtrati secondo i parametri
	 * @throws APIunreachable se l'API non restituisce i domini desiderati
	 * @see serviceImplementation#getFilter(String, String, String, String)
	 */

	@GetMapping("/filter")
		public ResponseEntity<Object> getFilter(@RequestParam(value="domain", defaultValue="") String domain,
												@RequestParam(value="hosting", defaultValue="") String hosting, 
	 											@RequestParam(value="update", defaultValue="") String update,
	 											@RequestParam(value="create", defaultValue="") String create) throws APIunreachable{
		
		return new ResponseEntity<>(ds.getFilter(domain, hosting, update, create),HttpStatus.OK);
	}
	
	
	
	/**
	 * Rotta che permette di filtrare i domini secondo un JSONObject fornito in input
	 * @param filtersBody JSONObject che conterrà i filtri da applicare
	 * @return HashSet di domini filtrati secondo il JSONObject
	 * @throws APIunreachable se l'API non restituisce i domini desiderati
	 * @see serviceImplementation#getFilter(JSONObject)
	 */
	@PostMapping("/filter")
		public ResponseEntity<Object> getFilter(@RequestBody JSONObject filtersBody) throws APIunreachable{
		return new ResponseEntity<>(ds.getFilter(filtersBody),HttpStatus.OK);
	}
	
	
	
	/**
	 * Rotta che calcola statistiche su un HashSet di domini filtrati o meno
	 * @param domain Testo che dovrà essere contenuto nel nome del dominio
	 * @param hosting Paese di hosting
	 * @param update Substring che dovrà essere presente nella data di update
	 * @param create Mese dell'anno in cui il dominio è stato creato
	 * @return JSONObject contenente le varie statistiche
	 * @throws APIunreachable se l'API non restituisce i domini desiderati
	 * @see serviceImplementation#getStats(String, String, String, String)
	 */
	@GetMapping("/stats")
	public ResponseEntity<Object> getStats(@RequestParam(value="domain", defaultValue="") String domain,
											@RequestParam(value="hosting", defaultValue="") String hosting, 
											@RequestParam(value="update", defaultValue="") String update,
											@RequestParam(value="create", defaultValue="") String create) throws APIunreachable{
	return new ResponseEntity<>(ds.getStats(domain, hosting, update, create), HttpStatus.OK);
	}
	
	
	
	
	/**
	 * Rotta che gestisce eccezioni riguardanti chiamate Get
	 * @return wrongRequest exception
	 * @throws wrongRequest se la richiesta non può essere processata
	 */
	@GetMapping("/error")
	 public ResponseEntity<Object> errorGet() throws wrongRequest {
		throw new wrongRequest();
	}
	
	/**
	 * Rotta che gestisce eccezioni riguardanti chiamate Post
	 * @return wrongRequest exception
	 * @throws wrongRequest se la richiesta non può essere processata
	 */
	@PostMapping("/error")
	 public ResponseEntity<Object> errorPost() throws wrongRequest {
		throw new wrongRequest();
	}
	
		
}