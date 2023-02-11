package it.paolorusso.GestionePrenotazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.paolorusso.GestionePrenotazioni.entity.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Integer> {

}
