package com.javaResource.security.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TBROLE")
@Getter
@Setter
@NoArgsConstructor
public class Role {
	
	@Id
	@GeneratedValue
	private int role_id;
	private String role;
}
