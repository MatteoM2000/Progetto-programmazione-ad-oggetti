package univpm.progettoOOP.stats;

import univpm.progettoOOP.model.Domain;

import org.json.simple.JSONObject;

import java.util.HashSet;

/**
 * <b>Superclasse</b> relativa al calcolo delle statistiche
 * @author Meloni Matteo
 * @author Rinaldi Alex
 * @version 1.0
 */

public abstract class Stats {
	
	/**
	 * <b>Hashset</b> contenente i domini sui quali verranno elaborate le statistiche
	 */
	
	HashSet<Domain> domainList;
	
	/**
     * <b>Costruttore</b> della classe
     * @param domainlist: Hashset dei domini sui quali elaborare le statistiche
     */
    public Stats(HashSet<Domain> domainList) {
    
    }
    /**
     * Metodo astratto per calcolare le statistiche
     */
    public abstract JSONObject calculateStat();
    }


