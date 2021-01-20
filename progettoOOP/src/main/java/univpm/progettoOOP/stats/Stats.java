package univpm.progettoOOP.stats;

import univpm.progettoOOP.model.Domain;

import org.json.simple.JSONObject;

import java.util.HashSet;

/**
 * Superclasse relativa al calcolo delle statistiche
 * @author Meloni Matteo
 * @author Rinaldi Alex
 * @version 1.0.0
 */

public abstract class Stats {
	
	/**
	 * Hashset contenente i domini sui quali verranno elaborate le statistiche
	 */
	
	HashSet<Domain> domainList;
	
	/**
     * Costruttore Stats(HashSet)
     * @param domainlist Hashset dei domini sui quali elaborare le statistiche
     */
    public Stats(HashSet<Domain> domainList) {
    	this.domainList = domainList;
    }
    /**
     * Metodo astratto per calcolare le statistiche
     */
    public abstract JSONObject calculateStat();
    }


