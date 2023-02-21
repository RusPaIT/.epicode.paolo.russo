package com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.entities.Utente;
import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.services.UtenteService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UtenteService utServ;
	
//	 @Override
//	 protected void configure(HttpSecurity http) throws Exception {
//	 http.authorizeRequests()
//	   	 .antMatchers(HttpMethod.GET, "/**").permitAll() 
//	     .antMatchers("/**").hasRole("ADMIN") 
//	 .anyRequest()
//	     .authenticated()
//	 .and()
//	 .httpBasic()
//	 .and()
//	 .formLogin()
//	     .successForwardUrl("/users/login_success")
//	 .and()
//	 .logout()
//	 .and()
//	 .csrf()
//	     .disable();
//	    }
//
//
//	@Override
//	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//		List<Utente> authUtenti = utServ.getAll();
//        for (Utente u : authUtenti) { 
//                auth.inMemoryAuthentication()
//                .withUser( u.getUsername() ).password( passwordEncoder().encode( u.getPassword() ) )
//                .roles(u.getType().toString());
//            }
//		
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
}

