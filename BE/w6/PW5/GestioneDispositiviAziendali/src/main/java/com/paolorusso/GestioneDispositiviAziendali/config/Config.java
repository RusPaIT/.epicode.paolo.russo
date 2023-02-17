package com.paolorusso.GestioneDispositiviAziendali.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.paolorusso.GestioneDispositiviAziendali.entities.Device;
import com.paolorusso.GestioneDispositiviAziendali.entities.User;
import com.paolorusso.GestioneDispositiviAziendali.enums.DeviceStatus;
import com.paolorusso.GestioneDispositiviAziendali.enums.DeviceType;
import com.paolorusso.GestioneDispositiviAziendali.enums.RoleType;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {
	
	@Bean
	@Scope("prototype")
	public User user(String u, String fn,String e, String p, RoleType rt) {
		return User.builder()
				.username(u)
				.fullname(fn)
				.email(e)
				.password(p)
				.type(rt)
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Device device(String n, DeviceType dt, DeviceStatus ds) {
	    return Device.builder()
	        .name(n)
	        .type(dt)
	        .status(ds)
	        .build();
	}

}
