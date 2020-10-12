package com.example.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.ApplicationUserForSpringDataRest;

@RepositoryRestResource(collectionResourceRel = "spdrest",path="spdrest")
public interface UserRepoForSpringdataRest extends PagingAndSortingRepository<ApplicationUserForSpringDataRest, Integer>{

	//http://localhost:8080/spdrest/search/findByEmail?email=g1@gmail.com --to acces below repository
	public ApplicationUserForSpringDataRest findByEmail(@Param("email")String email);	
}
