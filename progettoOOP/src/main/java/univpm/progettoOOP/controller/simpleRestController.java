package univpm.progettoOOP.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import univpm.progettoOOP.model.HelloWordClass;

@RestController
public class simpleRestController {
	@GetMapping("/ciao")
	public HelloWordClass esempio(@RequestParam(name="param1", defaultValue="Word") String param1) {
		return new HelloWordClass("Matteo", "Meloni");
	}
	@PostMapping("/ciao")
	public HelloWordClass esempio2(@RequestBody HelloWordClass body) {
		return body;
	}
	
}
