package com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.entities.Postazione;
import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.repository.PostazioneRepository;

@Service
public class PostazioneService {

	
	@Autowired
	private PostazioneRepository posRepo;
	
	public Postazione insert(Postazione p) {
		posRepo.save(p);
		System.out.println("Postazione inserita con successo");
		return p;
	}
	
	public List<Postazione> cercaPostazione(String t, String c){
		return posRepo.findByCittaETipo(c, t);
	}
	
	public void stampaLista(List<Postazione> p) {
		for(Postazione pi : p) {
			System.out.println(pi);
		}
	}
	
	public List<Postazione> getAll() {
		return posRepo.findAll();
	}
	
	public Optional<Postazione> getById(int id) {
		return posRepo.findById(id);
	}
}
