package univpm.progettoOOP.stats;

import univpm.progettoOOP.model.Domain;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.HashSet;


/**
 * Sottoclasse relativa alla statistica del paese di hosting
 * @author Meloni Matteo
 * @author Rinaldi Alex
 * @version 1.0.0
 */

public class hostingCountry extends Stats {
	
	/**
	 * JSONObject che contiene i paesi di hosting
	 */
	public final JSONObject hostingCountry = new JSONObject();
	
	/**
     * Costruttore  hostingCountry(HashSet)
     * @param domainlist Hashset dei domini sui quali elaborare le statistiche
     */
	public hostingCountry(HashSet<Domain> domainlist) {
		super(domainlist);
	}
	
	/**
	 * Metodo che elabora contatori sui paesi di hosting, restituendo un oggetto JSON
	 * @return JSONObject con i paesi di hosting
	 * @see Stats#calculateStat()
	 */
	
	@SuppressWarnings("unchecked")
	public JSONObject calculateStat() {
		
		
		HashMap <String, Integer> country = new HashMap<>();
		int contNull=0;
		for(Domain d: super.domainList) {
			if(d.getCountry()==null) contNull++;
			else {
				if(country.containsKey(d.getCountry()))
					country.compute(d.getCountry(),(key,val) -> val+1);
				else country.put(d.getCountry(), 1);
			}
		}
		if(contNull != 0)
			country.put("null", contNull);
		this.hostingCountry.put("Paesi di Hosting", country);
		return hostingCountry;

    }
				
	}


