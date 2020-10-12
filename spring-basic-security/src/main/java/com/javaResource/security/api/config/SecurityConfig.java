package com.javaResource.security.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.javaResource.security.api.service.CustomUserDeatilService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.inMemoryAuthentication().withUser("rama").password("rama").roles("ADMIN"
	 * ); auth.inMemoryAuthentication().withUser("chandu").password("rama").roles(
	 * "USER"); }
	 */
	// security for all api calls
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable().authorizeRequests().anyRequest().fullyAuthenticated().
	 * and().httpBasic(); }
	 */

	// security based on URL

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable().authorizeRequests().antMatchers("/rest/**").
	 * fullyAuthenticated().and().httpBasic(); }
	 */

	/*
	 * // Security based on role
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable().authorizeRequests().antMatchers("/rest/**").hasRole(
	 * "ADMIN") .anyRequest().fullyAuthenticated().and().httpBasic(); }
	 * 
	 * @Bean public static NoOpPasswordEncoder passwordEncoder() { return
	 * (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance(); }
	 */
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDeatilService();
	};

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(encodePWD());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/rest/**").permitAll().and()
		    .authorizeRequests().antMatchers("/admin**")
				.hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin().permitAll();
	}

	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}

}
