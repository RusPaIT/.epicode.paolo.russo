package com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.entities.Postazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM postazioni p INNER JOIN edifici e ON p.edificio_id = e.id WHERE p.tipo = :t AND e.citta = :c "
		)
		List<Postazione> findByCittaETipo(@Param("c") String c, @Param("t") String t);
	
}