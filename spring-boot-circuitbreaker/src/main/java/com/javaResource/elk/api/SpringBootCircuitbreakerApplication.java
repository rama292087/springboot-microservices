package com.javaResource.elk.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication
public class SpringBootCircuitbreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCircuitbreakerApplication.class, args);
	}

}
