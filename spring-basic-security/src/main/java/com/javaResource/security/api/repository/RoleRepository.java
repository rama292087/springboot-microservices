package com.javaResource.security.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaResource.security.api.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
