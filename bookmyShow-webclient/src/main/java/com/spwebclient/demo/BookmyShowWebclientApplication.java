package com.spwebclient.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BookmyShowWebclientApplication {
	
	/*
	 * WebClient webClient;
	 * 
	 * @PostConstruct public void init() { webClient =
	 * WebClient.builder().baseUrl("http://localhost:9090/BookMyShow/Service")
	 * .defaultHeader(HttpHeaders.CONTENT_TYPE,
	 * MediaType.APPLICATION_JSON_VALUE).build(); }
	 */
	public static void main(String[] args) {
		SpringApplication.run(BookmyShowWebclientApplication.class, args);
	}

}
