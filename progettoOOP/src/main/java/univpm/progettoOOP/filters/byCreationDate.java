package univpm.progettoOOP.filters;

import java.time.LocalDateTime;
import java.util.HashSet;

import univpm.progettoOOP.model.Domain;

public class byCreationDate extends Filter{

	public byCreationDate(HashSet<Domain> filteredList) {
		super(filteredList);
	}

	@Override
	public HashSet<Domain> toFilter(String value){
		for(Domain d: super.filteredList) {
			//String month = LocalDateTime.parse(d.getCreateDate()).getMonthValue();			
			//if(month != value) super.filteredList.remove(d);
		}
		return super.filteredList;
	}
}
