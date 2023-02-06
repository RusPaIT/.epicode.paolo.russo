package com.paolorusso.W4D1.d1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Prodotto {

    protected String nome;
    protected double prezzo;
    
    
    public Prodotto(String nome, double prezzo) {
    	this.nome = nome;
        this.prezzo = prezzo;
    }
}