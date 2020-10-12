package com.javaResource.cors.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringbootCorsController {
	
	@GetMapping("/access")
	public String greeting() {
		return "Welcome to java techie portal";
	}
}
