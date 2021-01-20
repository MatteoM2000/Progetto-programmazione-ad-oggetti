package univpm.progettoOOP.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import univpm.progettoOOP.model.Domain;

/**
 * Classe che gestisce le chiamate all'API
 * @author Matteo Meloni
 * @author Alex Rinaldi
 * @version 1.0.0
 */
public class DownloadJSON {
	
	/**
	 * Stringa contenente l'URL della chiamata
	 */
	public String url;
	
	
	/**
	 * Costruttore DownloadJSON(String)
	 * @param url
	 */
	public DownloadJSON(String url) {
		this.url = url;
	}

	/**
	 * Metodo che restituisce l'URL
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Metodo che imposta l'URL da input
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}


	
	/**
	 * Metodo che  chiama l'API e restituisce un HashSet con i domini passati dall'API
	 * @return HashSet con i domini restituiti dall'API
	 */
	public HashSet<Domain> APIcall(){
		HashSet<Domain> domainList = new HashSet<>();
		JSONParser parser = new JSONParser();
		try {
			HttpsURLConnection openConnection = (HttpsURLConnection) new URL(this.url).openConnection();
			openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			BufferedReader in = new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
			String s = in.readLine();
			if(!s.isEmpty()) {
				JSONObject domains = (JSONObject) parser.parse(s);
				JSONArray a = (JSONArray) domains.get("domains");
				Domain d;
				JSONObject domain;
				for(Object o: a) {
					domain = (JSONObject) o;
					d = new Domain((String) domain.get("domain"),(String) domain.get("create_date"),(String) domain.get("update_date"),
							(String) domain.get("country"),"true");
					domainList.add(d);
				}
			}
		}catch(IOException | ParseException e) {}
		
		return domainList;
	}
	
}
