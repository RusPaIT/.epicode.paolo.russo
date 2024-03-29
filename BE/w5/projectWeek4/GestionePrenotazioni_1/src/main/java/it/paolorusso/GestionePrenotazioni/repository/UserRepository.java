package it.paolorusso.GestionePrenotazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.paolorusso.GestionePrenotazioni.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {}
