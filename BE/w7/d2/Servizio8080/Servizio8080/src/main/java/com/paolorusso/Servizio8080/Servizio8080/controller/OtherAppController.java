package com.paolorusso.Servizio8080.Servizio8080.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/other")
public class OtherAppController {
	
	@GetMapping("/get-string")
	public String m1() {
		RestTemplate rt = new RestTemplate();
		String rtUrl = "http://localhost:8082/app/data1";
		ResponseEntity<String> response = rt.getForEntity(rtUrl, String.class);
		return "Response: \"" + response.getBody() + "\"";
	}
	
	@GetMapping("/get-people")
	public String m2() {
		RestTemplate rt = new RestTemplate();
		String rtUrl = "http://localhost:8082/app/data3";
		String response = rt.getForObject(rtUrl, String.class);
		return "people list: " + response;
	}
	
	@GetMapping("/get-people-Json")
	public Object m3Json() {
		RestTemplate rt = new RestTemplate();
		String rtUrl = "http://localhost:8082/app/data3";
		Object response = rt.getForObject(rtUrl, Object.class);
		return response;
	}

}
