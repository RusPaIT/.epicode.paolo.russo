package com.paolorusso.W4D1.d1;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Pizza extends Prodotto {
	
	private String base;
    private List<String> toppings;

    public Pizza(String nome, double prezzo, String base, List<String> toppings) {
        super(nome, prezzo);
        this.base = "Pomodoro e Mozzarella";
        this.toppings = toppings;
      }
    @Override
    public String toString() {
        return "\tPizza " + nome + " \tprezzo = " + prezzo + " Euro" +  " \tbase = " + base + " \tingrendienti aggiuntivi = " + toppings + "";
    }
}
