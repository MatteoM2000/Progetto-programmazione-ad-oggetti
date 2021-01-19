package univpm.progettoOOP.stats;

import univpm.progettoOOP.model.Domain;

import org.json.simple.JSONObject;

import java.util.HashSet;


/**
 * <b>Sottoclasse</b> relativa alla statistica della quantità
 * @author Meloni Matteo
 * @author Rinaldi Alex
 * @version 1.0
 */

public class Quantity extends Stats {
	
	/**
	 * Statistica della quantità
	 */
	public int quantity;
	
	/**
     * <b>Costruttore</b> della sottoclasse Quantity
     * @param domainList : Hashset dei domini sui quali elaborare le statistiche
     */
	public Quantity(HashSet<Domain> domainlist) {
		super(domainlist);
		this.quantity = 0;
	
	}
	
	/**
	 * <b>Metodo</b> che elabora il calcolo della quantita' di domini
	 */
    @SuppressWarnings("unchecked")
	public JSONObject calculateStat() {
    	this.quantity = super.domainList.size();
    	JSONObject Qjson = new JSONObject();
    	Qjson.put("Domini analizzati", this.quantity);
    	
    	
    return Qjson;
    }
}

