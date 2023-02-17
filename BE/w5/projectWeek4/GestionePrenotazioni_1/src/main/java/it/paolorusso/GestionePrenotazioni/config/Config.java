package it.paolorusso.GestionePrenotazioni.config;

import java.time.LocalDate;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.paolorusso.GestionePrenotazioni.entities.Device;
import it.paolorusso.GestionePrenotazioni.entities.Role;
import it.paolorusso.GestionePrenotazioni.entities.User;
import it.paolorusso.GestionePrenotazioni.enums.DeviceStatus;
import it.paolorusso.GestionePrenotazioni.enums.DeviceType;
import it.paolorusso.GestionePrenotazioni.enums.RoleType;



@Configuration
public class Config {
	
	@Bean
	@Scope("prototype")
	public User user(String u, String fn,String e, String p) {
		return User.builder()
				.username(u)
				.fullname(fn)
				.email(e)
				.password(p)
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Device device(String n, DeviceType t, DeviceStatus s) {
	    return Device.builder()
	        .name(n)
	        .type(t)
	        .status(s)
	        .build();
	}
	
	@Bean
	@Scope("prototype")
	public Role role(RoleType rt) {
		return Role.builder()
				.type(rt)
				.build();
	}

}