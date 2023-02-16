package it.paolorusso.GestionePrenotazioni.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.paolorusso.GestionePrenotazioni.entity.Prenotazione;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM prenotazioni WHERE data = :d AND postazione_id = :p"
		)
		Prenotazione controlloPrenotazione(@Param("d") LocalDate fn, @Param("p") int p);
	
	@Query(
			nativeQuery = true,
			value = "SELECT * FROM prenotazioni WHERE data = :d AND utente_id = :u"
		)
		Prenotazione controlloPrenotazioneUtente(@Param("d") LocalDate fn, @Param("u") int u);
	
}
