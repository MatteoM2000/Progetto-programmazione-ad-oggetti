package univpm.progettoOOP.filters;

import java.util.HashSet;

import univpm.progettoOOP.model.Domain;

/**
 * Classe che filtra in base alla data di update
 * @author Matteo Meloni
 * @author Alex Rinaldi
 * @version 1.0.0
 *
 */
public class byLastUpdate extends Filter{
	
	/**
	 * Costruttore byLastUpdate(HashSet)
	 * @param filteredList Lista di domini da filtrare
	 */
	public byLastUpdate(HashSet<Domain> filteredList) {
		super(filteredList);
	}
	
	/**
	 * Metodo che filtra in base alla data di update
	 * @param value La substring da ricercare
	 * @return HashSet della superclasse con domini filtrati
	 * @see Filter#toFilter(String)
	 * 
	 */
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
