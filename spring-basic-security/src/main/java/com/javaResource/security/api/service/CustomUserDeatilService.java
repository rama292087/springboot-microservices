package com.javaResource.security.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javaResource.security.api.model.User;
import com.javaResource.security.api.repository.UserRepository;

@Service
public class CustomUserDeatilService implements UserDetailsService{
	
	@Autowired
	private UserRepository respository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user=respository.findByUsername(username);
		CustomUserDeatils userDetails = null;
		if(user.isPresent()) {
			userDetails = new CustomUserDeatils();
			userDetails.setUser(user);
		}else {
			throw new UsernameNotFoundException("User not exist with name :: "+username);
		}
		return userDetails;
	}

}
