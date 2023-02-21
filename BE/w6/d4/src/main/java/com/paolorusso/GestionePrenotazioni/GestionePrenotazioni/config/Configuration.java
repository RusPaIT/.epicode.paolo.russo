package com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.entities.Edificio;
import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.entities.Postazione;
import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.entities.Prenotazione;
import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.entities.Role;
import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.entities.Utente;
import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.enums.RoleType;
import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.enums.TipoPostazione;

;



@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	@Scope("prototype")
	public Edificio edificio(String n, String i, String c) {
		return Edificio.builder()
				.nome(n)
				.indirizzo(i)
				.citta(c)
				.build();
	}
	
	
	@Bean
	@Scope("prototype")
	public Postazione postazione(String d, TipoPostazione t, int n, Edificio e) {
		return Postazione.builder()
				.descrizione(d)
				.tipo(t)
				.numMaxOccupanti(n)
				.edificio(e)
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Prenotazione prenotazione(Utente u, Postazione p, LocalDate d) {
		return Prenotazione.builder()
				.utente(u)
				.postazione(p)
				.data(d)
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Utente utente(String u, String c,String e, String p) {
		return Utente.builder()
				.username(u)
				.nomeCompleto(c)
				.email(e)
				.password(p)
				.active(true)
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