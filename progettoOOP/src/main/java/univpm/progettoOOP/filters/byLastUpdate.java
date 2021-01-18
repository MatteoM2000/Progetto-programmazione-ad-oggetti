package univpm.progettoOOP.filters;

import java.util.HashSet;

import univpm.progettoOOP.model.Domain;

public class byLastUpdate extends Filter{
	
	public byLastUpdate(HashSet<Domain> filteredList) {
		super(filteredList);
	}
	
	@Override
	public HashSet<Domain> toFilter(String value){
		HashSet<Domain> toRemove = new HashSet<>();
		for(Domain d: super.filteredList)
			if(d.getUpdateDate()!=null) {
				if(!d.getUpdateDate().contains(value))
					toRemove.add(d);
			} else toRemove.add(d);
		super.filteredList.removeAll(toRemove);
		return super.filteredList;
	}
}
