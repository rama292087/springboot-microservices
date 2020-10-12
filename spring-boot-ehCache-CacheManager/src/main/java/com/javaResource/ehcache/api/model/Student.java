package com.javaResource.ehcache.api.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String firstName;

	private String lastName;

	private String age;

	private Address address;
	
	private Major major;
	
}
