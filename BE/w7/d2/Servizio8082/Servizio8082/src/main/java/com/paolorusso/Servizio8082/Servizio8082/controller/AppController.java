package com.paolorusso.Servizio8082.Servizio8082.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paolorusso.Servizio8082.Servizio8082.entities.Person;

@RestController
@RequestMapping("/app")
public class AppController {
	
	@GetMapping("/data1")
	public String data1() {
		return "response";
	}
	
	@GetMapping("/data2") 
		public ResponseEntity<List<Person>> data2() {
			List<Person> people = new ArrayList<>(Arrays.asList(
				new Person ("Gino", "Paoli", 90),
				new Person ("Maurizio", "Costanzo", 85),
				new Person ("Gerry", "Scotty", 68),
				new Person ("Adriano", "Celentano", 82)
			));
			
			return new ResponseEntity<>(people, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/data3", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> data3() {
		List<Person> people = new ArrayList<>(Arrays.asList(
				new Person ("Gino", "Paoli", 90),
				new Person ("Maurizio", "Costanzo", 85),
				new Person ("Gerry", "Scotty", 68),
				new Person ("Adriano", "Celentano", 82)
			));
				
		return people;
	}
	
}
