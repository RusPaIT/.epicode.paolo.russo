package it.paolorusso.GestionePrenotazioni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.paolorusso.GestionePrenotazioni.entity.Role;
import it.paolorusso.GestionePrenotazioni.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepo;

	public Role saveRole(Role obj) {
		return roleRepo.save(obj);
	}
	
}
