package univpm.progettoOOP.stats;

import univpm.progettoOOP.model.Domain;

import org.json.simple.JSONObject;

import java.util.HashSet;


/**
 * Sottoclasse relativa alla statistica della quantità
 * @author Meloni Matteo
 * @author Rinaldi Alex
 * @version 1.0.0
 */

public class Quantity extends Stats {
	
	/**
	 * Statistica della quantità
	 */
	public int quantity;
	
	/**
     * Costruttore Quantity(HashSet)
     * @param domainList Hashset dei domini sui quali elaborare le statistiche
     */
	public Quantity(HashSet<Domain> domainlist) {
		super(domainlist);
		this.quantity = 0;
	
	}
	
	/**
	 * Metodo che elabora il calcolo della quantita' di domini
	 * @return Ritorna JSONObject che contiene la quantità
	 * @see Stats#calculateStat()
	 */
    @SuppressWarnings("unchecked")
	public JSONObject calculateStat() {
    	this.quantity = super.domainList.size();
    	JSONObject Qjson = new JSONObject();
    	Qjson.put("Domini analizzati", this.quantity);
    	
    	
    return Qjson;
    }
}

