package univpm.progettoOOP.service;

import univpm.progettoOOP.filters.*;
import univpm.progettoOOP.model.Domain;

import java.util.HashSet;
import java.time.LocalDateTime;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class ServiceImplementation implements DomainService{
	public HashSet<Domain> domainList = new HashSet<>();
	//costruttore
	public ServiceImplementation() {}
	
	public HashSet<Domain> getDomains(){
		DownloadJSON dj = new DownloadJSON("https://api.domainsdb.info/v1/domains/search?limit=50&zone=com&isDead=true");
		this.domainList = dj.APIcall();
		return domainList;
	}
	
	public Domain getMetadata(){
		String time = LocalDateTime.now().toString();
		Domain d = new Domain("string",time,time,"string","string");
		return d;
	}
	
	public HashSet<Domain> getFilter(String domain, String hosting, String update, String create){
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
		
		return this.domainList;
	}
	
	public HashSet<Domain> getFilter(JSONObject filterBody){
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
		
		return this.domainList;
	}

}
