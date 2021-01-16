package univpm.progettoOOP.service;

import java.util.HashSet;

import univpm.progettoOOP.model.Domain;

public interface DomainService {
	
	HashSet<Domain> getDomains();
	Domain getMetadata();
	HashSet<Domain> getFilter(String hosting, String update, String create);
	/*public getDomains();
	public getMetadata();
	public getFilter();
	getStats()*/
}
