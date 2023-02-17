package com.paolorusso.GestioneDispositiviAziendali.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paolorusso.GestioneDispositiviAziendali.entities.User;
import com.paolorusso.GestioneDispositiviAziendali.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository usRepo;
	
	public void insert(User u) {
		usRepo.save(u);
		System.out.println("Utente inserito con successo");
	}
	
	public List<User> getAll() {
		return usRepo.findAll();
	}
	
	public Optional<User> getById(int id) {
		return usRepo.findById(id);
	}
	
	public void deleteById(int id) {
		 usRepo.deleteById(id);
	}
	
	public void stampaLista(List<User> u) {
		for(User ui : u) {
			System.out.println(ui);
		}
	}
	
}