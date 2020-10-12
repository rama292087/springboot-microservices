package com.javaResource.security.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaResource.security.api.model.User;
import com.javaResource.security.api.repository.UserRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/add")
	public String addUserByAdmin(@RequestBody User user) {
		String pwd=user.getPassword();
		String encryptPwd = passwordEncoder.encode(pwd);
		user.setPassword(encryptPwd);
		userrepo.save(user);
		return "User added sucessfully....";
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/admin/all")
	public String securedHello() {
		return "Secured Hello";
	}
}
