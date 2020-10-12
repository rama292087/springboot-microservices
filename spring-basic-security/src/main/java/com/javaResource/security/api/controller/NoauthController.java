package com.javaResource.security.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/noAuth/rest")
public class NoauthController {

	@RequestMapping("/sayHi")
	public String noAuthmeth() {
		return "No Auth Requests";
	}
}
