package com.javaResource.security.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaResource.security.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);

}
