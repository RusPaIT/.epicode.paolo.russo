package com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.entities.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Integer> {

}
