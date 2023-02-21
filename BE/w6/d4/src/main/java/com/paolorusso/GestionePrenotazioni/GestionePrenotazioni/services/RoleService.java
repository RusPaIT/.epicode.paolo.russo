package com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.entities.Role;
import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepo;

	public Role saveRole(Role obj) {
		return roleRepo.save(obj);
	}
	
}