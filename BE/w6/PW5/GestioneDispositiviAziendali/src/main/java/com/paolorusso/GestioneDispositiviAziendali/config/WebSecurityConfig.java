package com.paolorusso.GestioneDispositiviAziendali.config;

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
	        http.csrf().disable()
	            .authorizeRequests()
	                .antMatchers(HttpMethod.GET, "/**").permitAll() 
	                .antMatchers("/**").hasRole("ADMIN") 
	            .and()
	            .httpBasic();
	    }


	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		Optional<User> authUserObj = usServ.getById(1);
		User authUser = authUserObj.get();
		String role = "USER";
		RoleType userRole = authUser.getType();
		
		if (userRole.toString().contains("ADMIN")) {
	        role = "ADMIN";
	    }
		
		auth.inMemoryAuthentication()
        .withUser(authUser.getUsername())
        .password(this.passwordEncoder().encode(authUser.getPassword()))
        .roles(role);
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
