package com.paolorusso.PW7.GestioneAllarmi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.paolorusso.PW7.GestioneAllarmi.classes.CenterControl;
import com.paolorusso.PW7.GestioneAllarmi.classes.Sensor;

@SpringBootApplication
public class GestioneAllarmiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioneAllarmiApplication.class, args);
		run();
	}
	
	public static void run() {
		
		CenterControl centerControl = new CenterControl();
		
		Sensor s1 = new Sensor(1, 12.345, 67.899);
		Sensor s2 = new Sensor(2, 34.345, 56.899);
		Sensor s3 = new Sensor(3, 78.345, 19.899);
		Sensor s4 = new Sensor(4, -12.345, 90.899);
		
		s1.addObserver(centerControl);
		s2.addObserver(centerControl);
		s3.addObserver(centerControl);
		s4.addObserver(centerControl);
		
		s1.setSmokeLevel(0);
	    s2.setSmokeLevel(4);
	    s3.setSmokeLevel(5);
	    s4.setSmokeLevel(8);
	}

}
