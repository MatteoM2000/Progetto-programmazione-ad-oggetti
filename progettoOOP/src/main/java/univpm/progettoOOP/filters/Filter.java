package univpm.progettoOOP.filters;

import java.util.HashSet;

import univpm.progettoOOP.model.Domain;

/**
 * Classe astratta che modella i filtri
 * @author Matteo Meloni
 * @author Alex Rinaldi
 * @version 1.0.0
 */
public abstract class Filter {
	
	/**
	 * HashSet contenente i domini da filtrare
	 */
	public HashSet<Domain> filteredList;
	
	
	/**
	 * Costruttore Filter(HashSet)
	 * @param domainList HashSet contenente i domini da filtrare
	 */
	public Filter(HashSet<Domain> domainList) {
		this.filteredList = domainList;
	}
	
	
	/**
	 * Metodo che filtra con logica AND l'HashSet che contiene i domini 
	 * @param value Il filtro da applicare
	 * @return HashSet di domini filtrati
	 */
	public HashSet<Domain> toFilter(String value){
		return this.filteredList;
	}
}
