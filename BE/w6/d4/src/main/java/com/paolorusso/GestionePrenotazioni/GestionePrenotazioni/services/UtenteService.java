package com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.entities.Utente;
import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.repository.UtenteRepository;


@Service
@Transactional
public class UtenteService {

	@Autowired
	private UtenteRepository utRepo;
	
	public void insert(Utente u) {
		utRepo.save(u);
		System.out.println("Utente inserito con successo");
	}
	
	public List<Utente> getAll() {
		return utRepo.findAll();
	}
	
	public Optional<Utente> getById(int id) {
		return utRepo.findById(id);
	}
	
	public void stampaLista(List<Utente> u) {
		for(Utente ui : u) {
			System.out.println(ui);
		}
	}
	
}
	
	