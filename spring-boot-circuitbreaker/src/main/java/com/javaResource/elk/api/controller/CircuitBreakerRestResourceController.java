package com.javaResource.elk.api.controller;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/rest")
public class CircuitBreakerRestResourceController {
	
	@HystrixCommand(fallbackMethod  = "fallbackHello", 
			commandProperties = {
					@HystrixProperty(
							name="execution.isolation.thread.timeoutInMilliseconds",value="500"
							)},
			commandKey ="hello",groupKey ="hello" )
	@GetMapping("/hello")
	public String hello() {
		//Wrong
		if(RandomUtils.nextBoolean()) {
			throw new RuntimeException("failed");
		}
		return "Hello World...";
	}
	
	
	@HystrixCommand(fallbackMethod  = "fallbackHello", commandKey ="helloYT",groupKey ="helloYT" )
	@GetMapping("/helloYT")
	public String helloYT() {
		//Wrong
		if(RandomUtils.nextBoolean()) {
			throw new RuntimeException("failed");
		}
		return "Hello World YT ....";
	}
	
	public String fallbackHello() {
		return "Fall back Hello initiated";
	}
}

