package com.javaResource.security.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class BasicAuthController {
	
	@RequestMapping("/getMsg")
	public String sayHello() {
		return "Authorized Request";
	}
}
