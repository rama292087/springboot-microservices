package com.javaResource.security.api.service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.javaResource.security.api.model.User;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CustomUserDeatils implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Optional<User> user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return user.get().getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return user.get().getPassword();
	}

	@Override
	public String getUsername() {
		return user.get().getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
