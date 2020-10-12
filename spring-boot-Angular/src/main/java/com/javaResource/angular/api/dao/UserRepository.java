package com.javaResource.angular.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaResource.angular.api.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	List<User> findByEmail(String email);
}
