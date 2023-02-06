package com.paolorusso.W4D1.d1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class D1Application {

	public static void main(String[] args) {
		SpringApplication.run(D1Application.class, args);
		Menu();
	}
		public static void Menu() {
			System.out.println("Pizze:");
			AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(GodfathersPizzaConfig.class);
			Prodotto pizzaMargherita = (Pizza) ctx.getBean("pizzaMargherita");
			Prodotto pizzaHawaiiana = (Pizza) ctx.getBean("pizzaHawaiiana");
			Prodotto cocaCola = (Bevanda) ctx.getBean("cocaCola");
			Prodotto acqua = (Bevanda) ctx.getBean("acqua");
			System.out.println(pizzaMargherita);
			System.out.println(pizzaHawaiiana);
			System.out.println("Bibite:");
			System.out.println(cocaCola);
			System.out.println(acqua);
			ctx.close();
			
		}
		
        
        
}
