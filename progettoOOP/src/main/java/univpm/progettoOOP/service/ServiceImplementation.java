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
		domainList = dj.APIcall();
		return domainList;
	}
	
	public Domain getMetadata(){
		String time = LocalDateTime.now().toString();
		Domain d = new Domain("string",time,time,"string","string");
		return d;
	}
	/*getDomains()
	getMetadata()
	getFilter()*/
}
