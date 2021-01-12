package univpm.progettoOOP.service;
import java.util.HashSet;

import univpm.progettoOOP.model.Domain;

public class DownloadJSON {
	public String url;
	
	public DownloadJSON(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public HashSet<Domain> APIcall(){
		
	}
	
}
