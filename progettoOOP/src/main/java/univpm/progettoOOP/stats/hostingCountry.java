package univpm.progettoOOP.stats;

import univpm.progettoOOP.model.Domain;

import org.json.simple.JSONObject;

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
		
		
		
		/**
		 * <b>Inizializzazione</b> contatori dei principali paesi di hosting, derivati dall'analisi sull'API
		 */
		
		int contUS = 0, contGB = 0, contIE = 0, contIT = 0, contDE = 0, contFR = 0, contJP = 0;
		int contAltro = 0, contNull = 0;
		
		for(Domain d: super.domainList) {
			if(d.getCountry()==null) contNull++;
			else {
				switch(d.getCountry()) {
    	
				case "US": contUS++;
    			       break;
    		
				case "GB": contGB++;
    	               break;
    	               
				case "IE": contIE++;
    	               break;
    	               
				case "IT": contIT++;
    	               break;
    	               
				case "DE": contDE++;
    	               break;
    	               
				case "FR": contFR++;
    		           break;
    		
				case "JP": contJP++;
						break;                       
				default:  contAltro++; 
				}
			}
        }
    	this.hostingCountry.put("US", contUS);
    	this.hostingCountry.put("GB", contGB);
    	this.hostingCountry.put("IE", contIE);
    	this.hostingCountry.put("IT", contIT);
    	this.hostingCountry.put("DE", contDE);
    	this.hostingCountry.put("FR", contFR);
    	this.hostingCountry.put("JP", contJP);
    	this.hostingCountry.put("null", contNull);
    	this.hostingCountry.put("altro", contAltro);

    	return hostingCountry;
    }
				
	}


