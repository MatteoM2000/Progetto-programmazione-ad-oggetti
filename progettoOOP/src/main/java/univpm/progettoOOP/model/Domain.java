package univpm.progettoOOP.model;

/**
 * Classe che modella i domini restituiti dall'API
 * @author Matteo Meloni
 * @author Alex Rinaldi
 * @version 1.0.0
 *
 */
public class Domain {
	
	/**
	 * Nome del dominio
	 */
	public String domain;
	
	/**
	 * Data di creazione del dominio
	 */
	public String createDate;
	
	/**
	 * Data dell'ultimo update
	 */
	public String updateDate;
	
	/**
	 * Nazionalità del dominio
	 */
	public String country;
	
	/**
	 * Indica se il dominio e' scaduto
	 */
	public String isDead;
	
	
	/**
	 * Costruttore Domain(String, String, String, String, String)
	 * @param domain Nome del dominio
	 * @param createDate Data di creazione del dominio
	 * @param updateDate Data dell'ultimo update
	 * @param country Nazionalita' del dominio
	 * @param isDead Indica se il dominio è scaduto
	 */
	public Domain(String domain, String createDate, String updateDate, String country, String isDead) {
		this.domain = domain;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.country = country;
		this.isDead = isDead;
	}

	/**
	 * Restituisce il nome del dominio
	 * @return domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * Imposta il nome del dominio
	 * @param domain
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

	
	/**
	 * Restituisce la data di creazione
	 * @return createDate
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * Imposta la data di creazione
	 * @param createDate
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	
	/**
	 * Restituisce la data dell'ultimo update
	 * @return updateDate
	 */
	public String getUpdateDate() {
		return updateDate;
	}

	/**
	 * Imposta la data dell'ultimo update
	 * @param updateDate
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	
	/**
	 * Restituisce la nazionalita' del dominio
	 * @return country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Imposta la nazionalita' del dominio
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	
	/**
	 * Restituisce true o false se il dominio e' scaduto o meno
	 * @return isDead
	 */
	public String isDead() {
		return isDead;
	}

	/**
	 * Imposta se il dominio e' scaduto
	 * @param isDead
	 */
	public void setDead(String isDead) {
		this.isDead = isDead;
	}
	
}
