package univpm.progettoOOP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import univpm.progettoOOP.service.*;
import univpm.progettoOOP.model.*;

public class appController {
	@Autowired
	DomainService ds;
	//String url; inserito in classi successive
	
	@GetMapping("/domains")
		public ResponseEntity<Object> getDomains(){
		//url = "https://api.domainsdb.info/v1/domains/search?limit=50&zone=com&isDead=true";
			return new ResponseEntity<>(ds.getDomains(),HttpStatus.OK);
	}
	
}
