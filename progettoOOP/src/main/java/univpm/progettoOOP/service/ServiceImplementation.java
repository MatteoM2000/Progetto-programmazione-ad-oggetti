package univpm.progettoOOP.service;

import univpm.progettoOOP.model.Domain;

import java.util.HashSet;

public class ServiceImplementation {
	public HashSet<Domain> domainList = new HashSet<>();
	public DownloadJSON dj = new DownloadJSON("https://api.domainsdb.info/v1/domains/search?limit=50&zone=com&isDead=true");
	//costruttore
	public ServiceImplementation() {}
	
	public HashSet<Domain> getDomains(){
		domainList = dj.APIcall();
		return domainList;
	}
	/*getDomains()
	getMetadata()
	getFilter()*/
}
