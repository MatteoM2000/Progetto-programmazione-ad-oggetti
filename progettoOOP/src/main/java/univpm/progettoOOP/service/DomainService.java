package univpm.progettoOOP.service;

import java.util.HashSet;

import org.json.simple.JSONObject;

import univpm.progettoOOP.exception.APInotworking;
import univpm.progettoOOP.exception.APIunreachable;
import univpm.progettoOOP.model.Domain;

public interface DomainService {
	
	HashSet<Domain> getDomains() throws APInotworking;
	Domain getMetadata();
	HashSet<Domain> getFilter(String domain, String hosting, String update, String create) throws APIunreachable;
	HashSet<Domain> getFilter(JSONObject filterBody) throws APIunreachable;
	JSONObject getStats(String domain, String hosting, String update, String create) throws APIunreachable;
	
}