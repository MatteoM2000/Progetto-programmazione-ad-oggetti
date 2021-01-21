package univpm.progettoOOP.service;

import univpm.progettoOOP.exception.APInotworking;
import univpm.progettoOOP.exception.APIunreachable;
import univpm.progettoOOP.filters.*;
import univpm.progettoOOP.model.Domain;
import univpm.progettoOOP.stats.Keywords;
import univpm.progettoOOP.stats.Quantity;
import univpm.progettoOOP.stats.Stats;
import univpm.progettoOOP.stats.UpdateTime;
import univpm.progettoOOP.stats.hostingCountry;

import java.util.HashSet;
import java.time.LocalDateTime;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;


/**
 * Classe che implementa l'interfaccia DomainService
 * @author Matteo Meloni
 * @author Alex Rinaldi
 * @version 1.0.0
 */
@Service
public class ServiceImplementation implements DomainService{
	
	/**
	 * HashSet di domini restituiti dall'API
	 */
	public HashSet<Domain> domainList = new HashSet<>();

	
	/**
	 * Costruttore ServiceImplementation()
	 */
	public ServiceImplementation() {}
	
	
	
	/**
	 * Metodo che restituisce i domini
	 * @return HashSet di domini commerciali non piu' attivi
	 * @throws APInotworking se l'API non restituisce domini con un URL standard verificato
	 * @see DownloadJSON#APIcall()
	 */
	public HashSet<Domain> getDomains() throws APInotworking{
		DownloadJSON dj = new DownloadJSON("https://api.domainsdb.info/v1/domains/search?limit=50&zone=com&isDead=true");
		this.domainList = dj.APIcall();
		if(this.domainList.isEmpty())
			throw new APInotworking();
		return domainList;
	}
	
	
	
	/**
	 * Metodo che restituisce i metadati
	 * @return Domain con i metadati dell'API
	 */
	public Domain getMetadata(){
		String time = LocalDateTime.now().toString();
		Domain d = new Domain("string",time,time,"string","string");
		return d;
	}
	
	
	
	/**
	 * Metodo che restituisce i domini filtrati per i parametri in input
	 * @param domain Testo che dovra' essere contenuto nel nome del dominio
	 * @param hosting Paese di hosting
	 * @param update Substring che dovra' essere presente nella data di update
	 * @param create Mese dell'anno in cui il dominio e' stato creato
	 * @return HashSet di domini filtrati secondo i parametri
	 * @throws APIunreachable se l'API non restituisce i domini desiderati
	 * @see DownloadJSON#APIcall()
	 */
	public HashSet<Domain> getFilter(String domain, String hosting, String update, String create) throws APIunreachable{
		Filter f;
		DownloadJSON dj;		
		String url =" https://api.domainsdb.info/v1/domains/search?limit=50&zone=com&isDead=true";
		if(!domain.isEmpty()) 
			url = url.concat("&domain=").concat(domain);
		if(!hosting.isEmpty()) 
			url = url.concat("&country=").concat(hosting);
		dj = new DownloadJSON(url);
		this.domainList = dj.APIcall();
		if(!update.isEmpty()) {
			f = new byLastUpdate(this.domainList);
			this.domainList = f.toFilter(update);
		}
		if(!create.isEmpty()) {
			f = new byCreationDate(this.domainList);
			this.domainList = f.toFilter(create);
		}
		if(this.domainList.isEmpty())
			throw new APIunreachable();
		else {return this.domainList;}
	}
	
	
	
	/**
	 * Metodo che restituisce i domini filtrati per il JSONObject in input
	 * @param filterBody JSONObject che conterra' i filtri da applicare
	 * @return HashSet di domini filtrati secondo il JSONObject
	 * @throws APIunreachable se l'API non restituisce i domini desiderati
	 * @see DownloadJSON#APIcall()
	 */
	public HashSet<Domain> getFilter(JSONObject filterBody) throws APIunreachable{
		Filter f;
		DownloadJSON dj;		
		String url =" https://api.domainsdb.info/v1/domains/search?limit=50&zone=com&isDead=true";
		if(filterBody.containsKey("domain")) 
			url = url.concat("&domain=").concat((String)filterBody.get("domain"));
		if(filterBody.containsKey("hosting")) 
			url = url.concat("&country=").concat((String)filterBody.get("hosting"));
		dj = new DownloadJSON(url);
		this.domainList = dj.APIcall();
		if(filterBody.containsKey("update")) {
			f = new byLastUpdate(this.domainList);
			this.domainList = f.toFilter((String)filterBody.get("update"));
		}
		if(filterBody.containsKey("create")) {
			f = new byCreationDate(this.domainList);
			this.domainList = f.toFilter((String)filterBody.get("create"));
		}
		if(this.domainList.isEmpty())
			throw new APIunreachable();
		
		else{return this.domainList;}
	}

	
	
	/**
	 * Metodo che calcola statistiche su un HashSet di domini filtrati o meno
	 * @param domain Testo che dovra' essere contenuto nel nome del dominio
	 * @param hosting Paese di hosting
	 * @param update Substring che dovra' essere presente nella data di update
	 * @param create Mese dell'anno in cui il dominio e' stato creato
	 * @return JSONObject contenente le varie statistiche
	 * @throws APIunreachable se l'API non restituisce i domini desiderati
	 */
	@SuppressWarnings("unchecked")
	public JSONObject getStats(String domain, String hosting, String update, String create) throws APIunreachable{
		try {
			getFilter(domain, hosting, update, create);
		} catch (Exception e) {
			throw new APIunreachable();
		}
		JSONObject Stat = new JSONObject();
		Stats s;		
		
		s= new hostingCountry (this.domainList);
		Stat.put("Nazione di Hosting", s.calculateStat());
		s= new Keywords (this.domainList);
		Stat.put("Parole chiave", s.calculateStat());
		s= new Quantity (this.domainList);
		Stat.put("Quantità domini", s.calculateStat());
		s= new UpdateTime (this.domainList);
		Stat.put("Tempo medio di Update", s.calculateStat());		
		
		return Stat;		
	}
	
}
