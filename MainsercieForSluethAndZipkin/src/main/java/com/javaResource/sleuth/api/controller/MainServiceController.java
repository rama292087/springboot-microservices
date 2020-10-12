package com.javaResource.sleuth.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainServiceController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MainServiceController.class);
	
	private static final String MAIN_SERVICE = "mainService";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	
	@GetMapping("/getSleuthTest")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> getSleuthTest(){
		LOGGER.info("I'm here in main service calling service Two");
		String response = restTemplate.getForObject("http://localhost:8081/serviceTwo", String.class);
		return new ResponseEntity<String>(response, HttpStatus.OK);
		
	}
	
	
	private  ResponseEntity<String> testFallBack(Exception e){
		return new ResponseEntity<String>("In fallback method", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
