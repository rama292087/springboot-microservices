package com.example.demo;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.ApplicationUserForSpringDataRest;
import com.example.demo.repository.UserRepoForSpringdataRest;

@SpringBootApplication
public class HateoasSpringtestApplication {

	@Autowired
	private UserRepoForSpringdataRest userrepo;

	@PostConstruct
	public void init() {
		userrepo.saveAll(Stream
				.of(new ApplicationUserForSpringDataRest(101, "Gopi", "g@gmail.com"),
						new ApplicationUserForSpringDataRest(102, "Gopi1", "g1@gmail.com"),
						new ApplicationUserForSpringDataRest(103, "Gopi2", "g2@gmail.com"),
						new ApplicationUserForSpringDataRest(104, "Gopi3", "g3@gmail.com"))
				.collect(Collectors.toList()));
	}

	public static void main(String[] args) {
		SpringApplication.run(HateoasSpringtestApplication.class, args);
	}

}
