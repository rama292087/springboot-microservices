package com.javaResource.angular.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaResource.angular.api.dto.Book;

@SpringBootApplication
@RestController
public class SpringBootAngularApplication {
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/findAllBooks")
	public List<Book> getBooks(){
		return Stream.of(new Book(1,"Java",400,"1",LocalDateTime.now(),20,10,2345),
				new Book(2,"Sql",300,"0",LocalDateTime.now(),30,20,3456),
				new Book(3,"spring boot",600,"-1",LocalDateTime.now(),40,30,34789))
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngularApplication.class, args);
	}

}
