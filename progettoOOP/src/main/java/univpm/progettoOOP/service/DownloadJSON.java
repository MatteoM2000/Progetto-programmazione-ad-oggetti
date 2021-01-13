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
	 //Chiamata API standard
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
