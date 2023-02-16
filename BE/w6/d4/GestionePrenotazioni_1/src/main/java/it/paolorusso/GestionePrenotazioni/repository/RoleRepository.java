package it.paolorusso.GestionePrenotazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.paolorusso.GestionePrenotazioni.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
