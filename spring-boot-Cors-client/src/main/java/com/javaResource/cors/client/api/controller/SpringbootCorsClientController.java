package com.javaResource.cors.client.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringbootCorsClientController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
}
