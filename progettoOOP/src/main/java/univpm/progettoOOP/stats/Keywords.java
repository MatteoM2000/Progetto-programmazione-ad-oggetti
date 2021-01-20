package univpm.progettoOOP.stats;

import univpm.progettoOOP.model.Domain;

import org.json.simple.JSONObject;

import java.util.HashSet;



/**
 * Sottoclasse relativa alla statistica delle parole chiave
 * @author Meloni Matteo
 * @author Rinaldi Alex
 * @version 1.0.0
 */

public class Keywords extends Stats {
	
	/**
	 * JSONObject della statistica relativa alle parole chiave
	 */
	public JSONObject Keyword = new JSONObject();
	
	/**
     * Costruttore Keywords(HashSet)
     * @param domainList HashSet dei domini nei quali elaborare la statistica
     */
	public Keywords(HashSet<Domain> domainList) {
			super(domainList);
	}
	
	/**
	 * Metodo che elabora il conteggio delle parole chiave
	 * @return JSONObject con le parole chiave presenti nei domini
	 * @see Stats#calculateStat()
	 */
	
	@SuppressWarnings("unchecked")
	public JSONObject calculateStat() {
    	int contFinancial = 0, contBusiness = 0, contLogin = 0, contMarketing = 0, contArchive = 0;
    	int contAltro = 0;
    	
    	for(Domain d: super.domainList) {
    		if(d.getDomain().contains("financial") | d.getDomain().contains("business") 
    				| d.getDomain().contains("login") | d.getDomain().contains("marketing")
    				| d.getDomain().contains("archive")) {
    			
    			if(d.getDomain().contains("financial"))
        			contFinancial++;
        		if(d.getDomain().contains("business"))
        				contBusiness++;
            	if(d.getDomain().contains("login"))
            				contLogin++;
                if(d.getDomain().contains("marketing"))
                				contMarketing++;
                if(d.getDomain().contains("archive"))
                    				contArchive++;
    		}
    		else
    			contAltro++;		
        }        				
        
    	this.Keyword.put("financial", contFinancial);
    	this.Keyword.put("business", contBusiness);
    	this.Keyword.put("login", contLogin);
    	this.Keyword.put("marketing", contMarketing);
    	this.Keyword.put("archive", contArchive);
    	this.Keyword.put("altro", contAltro);
    
    	return Keyword;
    	
    }	

}
