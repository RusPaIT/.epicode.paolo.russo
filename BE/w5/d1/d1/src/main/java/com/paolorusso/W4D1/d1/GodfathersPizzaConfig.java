package com.paolorusso.W4D1.d1;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GodfathersPizzaConfig {

	@Bean
	public Pizza pizzaMargherita() {
	    return new Pizza("Margherita", 10.0, null, null);
	}
	
	@Bean
	public Pizza pizzaHawaiiana() {
		List<String> toppings = Arrays.asList("Ananas", "Prosciutto");
		return new Pizza("Hawaiiana", 12.0, null,toppings);
	    }
    @Bean
    public Bevanda cocaCola() {
        return new Bevanda("Coca Cola", 2.0, "200 ml" );
    }

    @Bean
    public Bevanda acqua() {
        return new Bevanda("Acqua Minerale", 2.0, "500 ml" );
    }
 
}

