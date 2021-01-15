package univpm.progettoOOP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import univpm.progettoOOP.service.*;
import univpm.progettoOOP.model.*;

@RestController
public class appController {
	@Autowired
	DomainService ds;

	
	@GetMapping("/domains")
		public ResponseEntity<Object> getDomains(){
		return new ResponseEntity<>(ds.getDomains(), HttpStatus.OK);
		
		
	}
	
	@GetMapping("/metadata")
		public ResponseEntity<Object> getMetadata(){
		return new ResponseEntity<>(ds.getMetadata(), HttpStatus.OK);
	}
	
	@GetMapping("/filter/{hosting}/{update}")
		public ResponseEntity<Object> getFilter(@PathVariable String hosting,@PathVariable String update/*, @PathVariable String creation*/){
		return new ResponseEntity<>(ds.getFilter(hosting, update/*, creation*/), HttpStatus.OK);
	}
}