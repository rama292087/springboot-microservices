package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Users;

@RestController
@RequestMapping("/rest/users")
public class UserResourceController {

	@RequestMapping("/all")
	public List<Users> getAllUsers(){
		Users user1=new Users("Pater",2300L);
		Users user2=new Users("Sam",4300L);
		return Arrays.asList(user1,user2);
	}
	
	
	@RequestMapping(value = "/hateoas/all",produces = MediaTypes.HAL_JSON_VALUE)
	public List<Users> getHateoasUsers(){
		Users user1=new Users("Pater",2300L);
		/*
		 * Link link=ControllerLinkBuilder.linkTo(UserResourceController.class)
		 * .slash(user1.getName()).withSelfRel();
		 */
		Link link=WebMvcLinkBuilder.
				linkTo(UserResourceController.class)
				.slash(user1.getName()).withSelfRel();	
		Link link1=WebMvcLinkBuilder.linkTo(UserResourceController.class)
				.slash(user1.getSalary()).withRel("salary");
		user1.add(link,link1);
		Users user2=new Users("Sam",4300L);
		user2.add(link);
		return Arrays.asList(user1,user2);
	}
}
