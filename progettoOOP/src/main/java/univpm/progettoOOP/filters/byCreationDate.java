package univpm.progettoOOP.filters;

import java.util.HashSet;

import univpm.progettoOOP.model.Domain;

public class byCreationDate extends Filter{

	public byCreationDate(HashSet<Domain> filteredList) {
		super(filteredList);
	}


	@Override
	public HashSet<Domain> toFilter(String value){
		HashSet<Domain> toRemove = new HashSet<>();
		String s;
		for(Domain d: super.filteredList) {
			if(d.getCreateDate()!=null) {
				s = d.getCreateDate().substring(5, 7);
				if(!s.equals(value))
					toRemove.add(d);
			}else toRemove.add(d);
		}
		super.filteredList.removeAll(toRemove);
		return super.filteredList;
	}
}
