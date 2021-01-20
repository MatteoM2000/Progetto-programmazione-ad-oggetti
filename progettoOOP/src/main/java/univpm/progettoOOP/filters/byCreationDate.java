package univpm.progettoOOP.filters;

import java.util.HashSet;

import univpm.progettoOOP.model.Domain;

/**
 * Classe che filtra in base al mese di creazione del dominio
 * @author Matteo Meloni
 * @author Alex Rinaldi
 * @version 1.0.0
 *
 */
public class byCreationDate extends Filter{

	/**
	 * Costruttore byCreationDate(HashSet)
	 * @param filteredList Lista di domini da filtrare
	 */
	public byCreationDate(HashSet<Domain> filteredList) {
		super(filteredList);
	}


	/**
	 * Metodo che filtra in base al mese di creazione
	 * @param value Il mese desiderato
	 * @return HashSet della superclasse con domini filtrati
	 * @see Filter#toFilter(String)
	 * 
	 */
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
