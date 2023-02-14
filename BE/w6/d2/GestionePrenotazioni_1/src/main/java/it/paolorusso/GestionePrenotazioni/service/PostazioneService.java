package it.paolorusso.GestionePrenotazioni.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.paolorusso.GestionePrenotazioni.entity.Postazione;
import it.paolorusso.GestionePrenotazioni.repository.PostazioneRepository;

@Service
public class PostazioneService {

	
	@Autowired
	private PostazioneRepository posRepo;
	
	public void insert(Postazione p) {
		posRepo.save(p);
		System.out.println("Postazione inserita con successo");
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
