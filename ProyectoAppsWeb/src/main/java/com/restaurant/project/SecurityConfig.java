package com.restaurant.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//habilitar seguridad
//@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
		//Ventanas publicas
		http.authorizeHttpRequests().antMatchers("/index/","/platos/criollo","/platos/frio","/platos/carta","/resources/css/styleIndex.css","/").permitAll().anyRequest().authenticated()
		.and()
			.formLogin(form-> form.loginPage("/login")
			.permitAll()
			.defaultSuccessUrl("/platos/"));
		return http.build();
		
		
		
		
	}
	
	
	
	
	
	
}
