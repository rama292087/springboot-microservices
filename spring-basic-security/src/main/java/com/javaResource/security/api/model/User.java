package com.javaResource.security.api.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Getter;

import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TBUSER")
public class User {
	@Id
	@GeneratedValue
	private int user_id;
	@NotNull
	private String username;
	private String password;
	private String email;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "TBUSER_ROLE",
	joinColumns = @JoinColumn(name="userId"),inverseJoinColumns = @JoinColumn(name="roleId"))
	private Set<Role> roles;
}
