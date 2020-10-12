package com.example.demo.componentcls;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;

@Component
public class DatabaseLoader {
	@Bean
	CommandLineRunner init(OrderRepository repository) {
		return args -> {
			repository.save(new Order("grande mocha"));
			repository.save(new Order("venti hazelnut machiatto"));
		};
	}

}
