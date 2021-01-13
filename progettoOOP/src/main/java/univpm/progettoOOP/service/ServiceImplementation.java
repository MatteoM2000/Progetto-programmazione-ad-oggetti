package univpm.progettoOOP.service;

import univpm.progettoOOP.model.Domain;

import java.util.HashSet;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class ServiceImplementation implements DomainService{
	public HashSet<Domain> domainList = new HashSet<>();
	//costruttore
	public ServiceImplementation() {}
	
	public HashSet<Domain> getDomains(){
		DownloadJSON dj = new DownloadJSON("https://api.domainsdb.info/v1/domains/search?limit=50&zone=com&isDead=true");
		return dj.APIcall();
	}
	
	public Domain getMetadata(){
		Domain d = new Domain("string",LocalDateTime.now().toString(),LocalDateTime.now().toString(),"string",false);
		return d;
	}
	/*getDomains()
	getMetadata()
	getFilter()*/
}
