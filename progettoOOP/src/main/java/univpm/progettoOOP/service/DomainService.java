package univpm.progettoOOP.service;

import java.util.HashSet;

import org.json.simple.JSONObject;

import univpm.progettoOOP.exception.APInotworking;
import univpm.progettoOOP.exception.APIunreachable;
import univpm.progettoOOP.model.Domain;

/**
 * Interfaccia che gestisce le operazioni sui domini
 * @author Matteo Meloni
 * @author Alex Rinaldi
 * @version 1.0.0
 *
 */
public interface DomainService {
	
	/**
	 * Intestazione metodo che restituisce i domini
	 * @return HashSet di domini commerciali non più attivi
	 * @throws APInotworking se l'API non restituisce domini con un URL standard verificato
	 */
	HashSet<Domain> getDomains() throws APInotworking;
	
	/**
	 * Intestazione metodo che restituisce i metadati
	 * @return Domain con i metadati dell'API
	 */
	Domain getMetadata();
	
	/**
	 * Intestazione metodo che restituisce i domini filtrati per i parametri in input
	 * @param domain Testo che dovrà essere contenuto nel nome del dominio
	 * @param hosting Paese di hosting
	 * @param update Substring che dovrà essere presente nella data di update
	 * @param create Mese dell'anno in cui il dominio è stato creato
	 * @return HashSet di domini filtrati secondo i parametri
	 * @throws APIunreachable se l'API non restituisce i domini desiderati
	 */
	HashSet<Domain> getFilter(String domain, String hosting, String update, String create) throws APIunreachable;
	
	/**
	 * Intestazione metodo che restituisce i domini filtrati per il JSONObject in input
	 * @param filterBody JSONObject che conterrà i filtri da applicare
	 * @return HashSet di domini filtrati secondo il JSONObject
	 * @throws APIunreachable se l'API non restituisce i domini desiderati
	 */
	HashSet<Domain> getFilter(JSONObject filterBody) throws APIunreachable;
	
	/**
	 * Intestazione metodo che calcola statistiche su un HashSet di domini filtrati o meno
	 * @param domain Testo che dovrà essere contenuto nel nome del dominio
	 * @param hosting Paese di hosting
	 * @param update Substring che dovrà essere presente nella data di update
	 * @param create Mese dell'anno in cui il dominio è stato creato
	 * @return JSONObject contenente le varie statistiche
	 * @throws APIunreachable se l'API non restituisce i domini desiderati
	 */
	JSONObject getStats(String domain, String hosting, String update, String create) throws APIunreachable;
	
}