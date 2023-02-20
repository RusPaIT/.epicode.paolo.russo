package com.paolorusso.GestioneDispositiviAziendali.config;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.paolorusso.GestioneDispositiviAziendali.entities.User;
import com.paolorusso.GestioneDispositiviAziendali.enums.RoleType;
import com.paolorusso.GestioneDispositiviAziendali.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService usServ;
	
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
	 http.authorizeRequests()
	   	 .antMatchers(HttpMethod.GET, "/**").permitAll() 
	     .antMatchers("/**").hasRole("ADMIN") 
	 .anyRequest()
	     .authenticated()
	 .and()
	 .httpBasic()
	 .and()
	 .formLogin()
	     .successForwardUrl("/users/login_success")
	 .and()
	 .logout()
	 .and()
	 .csrf()
	     .disable();
	    }


	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		List<User> authUtenti = usServ.getAll();
        for (User u : authUtenti) { 
                auth.inMemoryAuthentication()
                .withUser( u.getUsername() ).password( passwordEncoder().encode( u.getPassword() ) )
                .roles(u.getType().toString());
            }
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
