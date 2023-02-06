package com.paolorusso.W4D1.d1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bevanda extends Prodotto {
	
	private String volume;
	
	public Bevanda(String nome, double prezzo, String volume) {
        super(nome, prezzo);
        this.volume = volume;
      }
	
    @Override
    public String toString() {
        return "\t " + nome + " \tprezzo = " + prezzo + " Euro" +  " \tvolume = " + volume + "";
    }

}