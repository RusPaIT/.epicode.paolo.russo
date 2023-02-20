package com.paolorusso.GestioneDispositiviAziendali;


import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.paolorusso.GestioneDispositiviAziendali.config.Config;
import com.paolorusso.GestioneDispositiviAziendali.entities.Device;
import com.paolorusso.GestioneDispositiviAziendali.entities.User;
import com.paolorusso.GestioneDispositiviAziendali.enums.DeviceStatus;
import com.paolorusso.GestioneDispositiviAziendali.enums.DeviceType;
import com.paolorusso.GestioneDispositiviAziendali.enums.RoleType;
import com.paolorusso.GestioneDispositiviAziendali.service.DeviceService;
import com.paolorusso.GestioneDispositiviAziendali.service.UserService;




@SpringBootApplication
public class GestioneDispositiviAziendali implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GestioneDispositiviAziendali.class, args);
	}


	@Autowired
	UserService usServ;

	@Autowired
	DeviceService deServ;

	ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

	@Override
	public void run(String... args) throws Exception {
//		popolaDB();

	}
	
	public void popolaDB() {
		User u1 = (User) ctx.getBean("user", "Paolo", "Paolo Bonolis", "p@bonolis.it", "pass1", RoleType.ADMIN);
		User u2 = (User) ctx.getBean("user", "Jon", "Jon Jesus", "j@jesus.it", "pass2", RoleType.USER);
		User u3 = (User) ctx.getBean("user", "Gerry", "Gerry Scotti", "s@scotti.it", "pass3",RoleType.USER);
		Device d1 = (Device)ctx.getBean("device", "Smartphone di Paolo",DeviceType.SMARTPHONE, DeviceStatus.ASSEGNATO);
		Device d2 = (Device)ctx.getBean("device", "Laptop di Jesus",DeviceType.LAPTOP, DeviceStatus.ASSEGNATO);
		Device d3 = (Device)ctx.getBean("device", "Tablet di Gerry",DeviceType.TABLET, DeviceStatus.ASSEGNATO);
		Device d4 = (Device)ctx.getBean("device", "Smartphone dismesso",DeviceType.SMARTPHONE, DeviceStatus.DISMESSO);
		Device d5 = (Device)ctx.getBean("device", "Laptop Libero",DeviceType.LAPTOP, DeviceStatus.DISPONIBILE);
		Device d6 = (Device)ctx.getBean("device", "Tablet in manutenzione",DeviceType.TABLET, DeviceStatus.IN_MANUTENZIONE);
//		u1.setDevices(new HashSet<>() {{
//			add(d1);
//		}});
//		u2.setDevices(new HashSet<>() {{
//			add(d2);
//		}});
//		u3.setDevices(new HashSet<>() {{
//			add(d3);
//		}});
		usServ.insert(u1);
		usServ.insert(u2);
		usServ.insert(u3);
		deServ.insert(d1);
		deServ.insert(d2);
		deServ.insert(d3);
		deServ.insert(d4);
		deServ.insert(d5);
		deServ.insert(d6);
	}

}
