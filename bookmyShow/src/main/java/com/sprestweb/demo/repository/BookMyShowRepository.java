package com.sprestweb.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprestweb.demo.model.BookRequest;

public interface BookMyShowRepository extends JpaRepository<BookRequest, Integer>{

}
