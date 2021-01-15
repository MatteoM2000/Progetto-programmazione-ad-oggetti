package univpm.progettoOOP.filters;

import java.util.HashSet;

import univpm.progettoOOP.model.Domain;

public class byLastUpdate extends Filter{
	
	public byLastUpdate(HashSet<Domain> filteredList) {
		super(filteredList);
	}
	
	@Override
	public HashSet<Domain> toFilter(String value){
		for(Domain d: super.filteredList)
			if(!d.getUpdateDate().contains(value)) super.filteredList.remove(d);
		return super.filteredList;
	}
}
