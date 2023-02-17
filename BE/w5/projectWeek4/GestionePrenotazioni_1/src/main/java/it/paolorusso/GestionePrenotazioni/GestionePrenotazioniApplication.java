package it.paolorusso.GestionePrenotazioni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.paolorusso.GestionePrenotazioni.config.Config;
import it.paolorusso.GestionePrenotazioni.entities.User;
import it.paolorusso.GestionePrenotazioni.service.DeviceService;
import it.paolorusso.GestionePrenotazioni.service.RoleService;
import it.paolorusso.GestionePrenotazioni.service.UserService;

@SpringBootApplication
public class GestionePrenotazioniApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GestionePrenotazioniApplication.class, args);
	}


	@Autowired
	UserService usServ;

	@Autowired
	DeviceService deServ;
	
	@Autowired
	RoleService roleServ;

	ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

	@Override
	public void run(String... args) throws Exception {
		popolaDB();
		
		System.out.println("ciao");

	}
	
	public void popolaDB() {
		User u1 = (User) ctx.getBean("Paolo", "Paolo Bonolis", "p@bonolis.it", "pass1");
//		Device d1 = (Device)ctx.getBean("Smartphone di Paolo",DeviceType.SMARTPHONE, DeviceStatus.ASSEGNATO);
//		Role r1 = (Role)ctx.getBean("role", RoleType.ROLE_ADMIN);
//		u1.setDevices(new HashSet<>() {{
//			add(d1);
//		}});
		System.out.println(u1);
		usServ.insert(u1);
//		deServ.insert(d1);
//		roleServ.saveRole(r1);
	}

}