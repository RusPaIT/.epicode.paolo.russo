package com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.entities.Edificio;
import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.repository.EdificioRepository;

@Service
public class EdificioService {
	

	@Autowired
	private EdificioRepository edRepo;
	
	public void insert(Edificio e) {
		edRepo.save(e);
		System.out.println("Edificio inserito con successo");
	}
	
	public Optional<Edificio> getEdificioById(int id) {
		return edRepo.findById(id);
	}
	
	public List<Edificio> getAll() {
		return edRepo.findAll();
	}
	
	public Optional<Edificio> getById(int id) {
		return edRepo.findById(id);
	}
	
	public void stampaLista(List<Edificio> e) {
		for(Edificio ed : e) {
			System.out.println(ed);
		}
	}
	
	public void deleteById(int id) {
		 edRepo.deleteById(id);
	}
	
    public Page<Edificio> getAll(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return edRepo.findAll(pageRequest);
    }
    
    public Page<Edificio> getAll_page(Pageable pageable) {
        return edRepo.findAll(pageable);
    }
}