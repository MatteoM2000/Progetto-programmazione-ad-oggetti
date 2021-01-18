package univpm.progettoOOP.filters;

import java.util.HashSet;

import univpm.progettoOOP.model.Domain;

public abstract class Filter {
	
	public HashSet<Domain> filteredList;
	
	public Filter(HashSet<Domain> domainList) {
		this.filteredList = domainList;
	}
	
	public HashSet<Domain> toFilter(String value){
		return this.filteredList;
	}
	//toFilter()
	//getStats()
}
