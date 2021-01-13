package univpm.progettoOOP.model;

public class Domain {
	public String domain;
	public String createDate;
	public String updateDate;
	public String country;
	public String isDead;
	
	public Domain(String domain, String createDate, String updateDate, String country, String isDead) {
		this.domain = domain;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.country = country;
		this.isDead = isDead;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String isDead() {
		return isDead;
	}

	public void setDead(String isDead) {
		this.isDead = isDead;
	}
	
}
