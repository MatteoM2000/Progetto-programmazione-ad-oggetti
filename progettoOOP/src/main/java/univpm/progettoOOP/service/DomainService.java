package univpm.progettoOOP.service;

import java.util.HashSet;

import org.json.simple.JSONObject;

import univpm.progettoOOP.exception.APIunreachable;
import univpm.progettoOOP.model.Domain;

public interface DomainService {
	
	HashSet<Domain> getDomains();
	Domain getMetadata();
	HashSet<Domain> getFilter(String domain, String hosting, String update, String create);
	HashSet<Domain> getFilter(JSONObject filterBody);
	JSONObject getStats(String domain, String hosting, String update, String create);
	
}