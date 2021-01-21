package univpm.progettoOOP.stats;

import univpm.progettoOOP.model.Domain;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.HashMap;
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
	 * Metodo che elabora il conteggio delle parole chiave sulla base di un JSONArray contenente le parole inglesi piu' utilizzate
	 * @return JSONObject con le parole chiave presenti nei domini
	 * @see Stats#calculateStat()
	 */
	
	@SuppressWarnings("unchecked")
	public JSONObject calculateStat() {
    	HashMap <String, Integer> findedWords = new HashMap<>();
		JSONParser parser = new JSONParser();
		
		try {
			Object object = parser.parse(new FileReader("src//main//resources/keywords.json"));
			JSONObject commonWords = (JSONObject)object;
			JSONArray a = (JSONArray) commonWords.get("commonWords");
			String s;
			for(Object o: a) {
				s = (String) o;
				for(Domain d: this.domainList) {
					if(d.getDomain().contains(s)) {
						if(findedWords.containsKey(s))
							findedWords.compute(s,(key,val) -> val+1);
						else findedWords.put(s, 1);
					}
				}
			}
		}catch(Exception e) {
			e.getMessage();
			e.getStackTrace();
		}
		
		if(findedWords.size()!=0)
			this.Keyword.put("Keywords trovate",findedWords);
		else this.Keyword.put("Keywords trovate", 0);
    	return Keyword;
    	
    }	

}
