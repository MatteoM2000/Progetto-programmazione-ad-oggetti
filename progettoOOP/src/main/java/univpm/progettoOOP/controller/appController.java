package univpm.progettoOOP.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import univpm.progettoOOP.exception.APIunreachable;
import univpm.progettoOOP.service.*;

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
	


	@GetMapping("/filter")
		public ResponseEntity<Object> getFilter(@RequestParam(value="domain", defaultValue="") String domain,
												@RequestParam(value="hosting", defaultValue="") String hosting, 
	 											@RequestParam(value="update", defaultValue="") String update,
	 											@RequestParam(value="create", defaultValue="") String create){
		
		return new ResponseEntity<>(ds.getFilter(domain, hosting, update, create),HttpStatus.OK);
	}
	
	@PostMapping("/filter")
		public ResponseEntity<Object> getFilter(@RequestBody JSONObject filtersBody){
		return new ResponseEntity<>(ds.getFilter(filtersBody),HttpStatus.OK);
	}
	
	@GetMapping("/stats")
	public ResponseEntity<Object> getStats(@RequestParam(value="domain", defaultValue="") String domain,
											@RequestParam(value="hosting", defaultValue="") String hosting, 
											@RequestParam(value="update", defaultValue="") String update,
											@RequestParam(value="create", defaultValue="") String create){
	return new ResponseEntity<>(ds.getStats(domain, hosting, update, create), HttpStatus.OK);
	}
	
		
}