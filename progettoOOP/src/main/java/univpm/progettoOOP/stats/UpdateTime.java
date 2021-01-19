package univpm.progettoOOP.stats;

import univpm.progettoOOP.model.Domain;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.json.simple.JSONObject;
import java.util.HashSet;
import java.util.List;



/**
 * <b>Sottoclasse</b> relativa alla statistica del tempo medio di Update
 * @author Meloni Matteo
 * @author Rinaldi Alex
 * @version 1.0
 */

public class UpdateTime extends Stats {

	/**
	 * Statistica relativa al tempo medio di Update
	 */
	public double AverageUpdateTime = 0;
	
	/**
     * <b>Costruttore</b> della sottoclasse tempo medio di Update
     * @param domainList : Hashset di domini sui quali elaborare le statistiche
     */
	public UpdateTime(HashSet<Domain> domainList)  {
		super(domainList);
	}
		
	/**
	 * <b>Metodo</b> che elabora il calcolo del tempo medio di Update dei domini
	 * @see Domain#getCreateDate()
	 */
    @SuppressWarnings("unchecked")
	public JSONObject calculateStat() {
    	LocalDateTime today = LocalDateTime.now();
    	long oneUpdateTime, UpdateTimes = 0;

		for (Domain domainsStat : super.domainList) {
			if (domainsStat.getCreateDate() != null) {
				LocalDateTime createDate = LocalDateTime.parse(domainsStat.getCreateDate());
				oneUpdateTime = ChronoUnit.DAYS.between(createDate, today);
			} else
				oneUpdateTime = 0;
			UpdateTimes += oneUpdateTime;
		}
		
			this.AverageUpdateTime = UpdateTimes / super.domainList.size();
			JSONObject UTjson = new JSONObject();
	    	UTjson.put("Tempo medio update domini in giorni", this.AverageUpdateTime);
	    	return UTjson;
    }
			
}
