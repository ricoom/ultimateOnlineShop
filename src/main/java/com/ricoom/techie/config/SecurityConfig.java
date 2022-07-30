package com.ricoom.techie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ricoom.techie.services.UserService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private UserService userservice;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userservice).passwordEncoder(PasswordEncoder());
	}

	

	



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/addProduct").hasAnyRole("ADMIN")
				.antMatchers("/saveProduct").hasAnyRole("ADMIN")
				.antMatchers("/api/**").hasAnyRole("ADMIN","USER")

		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll();
		}
	
	@Bean
	public PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers("/resources/**","/webjars/**","/css/**","/js/**","/img/**");
		
		
	}





	

}
