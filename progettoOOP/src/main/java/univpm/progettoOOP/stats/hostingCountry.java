package univpm.progettoOOP.stats;

import univpm.progettoOOP.model.Domain;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.HashSet;


/**
 * <b>Sottoclasse</b> relativa alla statistica del paese di hosting
 * @author Meloni Matteo
 * @author Rinaldi Alex
 * @version 1.0
 */

public class hostingCountry extends Stats {
	
	public final JSONObject hostingCountry = new JSONObject();
	
	/**
     * <b>Costruttore</b> della sottoclasse hostingCountry
     * @param domainlist : Hashset dei domini sui quali elaborare le statistiche
     */
	public hostingCountry(HashSet<Domain> domainlist) {
		super(domainlist);
	}
	
	/**
	 * <b>Metodo</b> che elabora contatori sui paesi di hosting, <b>restituendo</b> un oggetto JSON
	 * @see Domain#getCountry()
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
		country.put("null", contNull);
		this.hostingCountry.put("Paesi di Hosting", country);
		return hostingCountry;

    }
				
	}


