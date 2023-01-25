package utils;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Concerto;
import entities.Evento;
import entities.EventoDAO;
import entities.Genere;
import entities.Location;
import entities.LocationDAO;
import entities.PartecipazioneDAO;
import entities.Persona;
import entities.PersonaDAO;
import entities.Sesso;
import entities.TipoEvento;

public class JpaUtil {

	private static final String persistenceUnit = "w3d3";
	public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
	public static final EntityManager em = emf.createEntityManager();
	public static final EntityTransaction t = em.getTransaction();

	public static void main(String[] args) {

		EventoDAO dao = new EventoDAO();

		Concerto concerto = new Concerto();
		PersonaDAO personaDAO = new PersonaDAO();
		Persona persona = new Persona();
		PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();
		LocationDAO locationDAO = new LocationDAO();
		Location location = new Location();

		boolean savep = true;
		boolean savec = false;
		boolean save = false;
		boolean getById = false;
		boolean delete = false;
		boolean refresh = false;
		


		if (savep) {
			try {
				   persona.setNome("Antonello");
				    persona.setCognome("Venditti");
				    persona.setEmail("antonello.venditti@gmail.com");
				    persona.setDataNascita(LocalDate.of(1950, 1, 1));
				    persona.setSesso(Sesso.M);

				    personaDAO.save(persona);
				    System.out.println("Persona inserita");
				}catch (Exception e) {
					System.out.println("Errore durante il salvataggio della persona: " + e.getMessage());
				}
			

			
			
		    location.setNome("Sala concerti");
		    location.setCitta("Roma");
		    locationDAO.save(location);
		    System.out.println("Location inserita");
			
			
			try {
				Evento evento = new Evento();
				evento.setTitolo("Funerale");
				evento.setDataEvento(LocalDate.of(2090, 12, 25));
				evento.setDescrizione("Funerale di jhon j");
				evento.setTipoEvento(TipoEvento.PRIVATO);
				evento.setNumeroMassimoPartecipanti(50);
				dao.save(evento);
				System.out.println("Evento salvato");
				partecipazioneDAO.savePartecipazioneWithPersonAndEvent(persona, evento);
			} catch (Exception e) {
				System.out.println("Errore durante il salvataggio dell'evento: " + e.getMessage());
			}
			
		}
		

		if (savec) {
			try {
				concerto.setTitolo("Compleanno Paolo");
				concerto.setDataEvento(LocalDate.of(2022, 02, 04));
				concerto.setDescrizione("Alcolizzata imperiale");
				concerto.setTipoEvento(TipoEvento.PRIVATO);
				concerto.setGenere(Genere.ROCK);
				concerto.setNumeroMassimoPartecipanti(50);
				concerto.setInStreaming(false);

				dao.save(concerto);
				System.out.println("Concerto salvato");

			} catch (Exception e) {
				System.out.println("Errore durante il salvataggio dell'evento: " + e.getMessage());
			}
		}

		if (save) {
			try {
				Evento evento = new Evento();
				evento.setTitolo("Festa di compleanno");
				evento.setDataEvento(LocalDate.of(2022, 12, 25));
				evento.setDescrizione("Festa di compleanno con amici e familiari");
				evento.setTipoEvento(TipoEvento.PRIVATO);
				evento.setNumeroMassimoPartecipanti(50);
				dao.save(evento);
				System.out.println("Evento salvato");
				
			} catch (Exception e) {
				System.out.println("Errore durante il salvataggio dell'evento: " + e.getMessage());
			}
		}

		if (getById) {
			try {
				Evento evento = dao.getById(1);
				System.out.println("L' evento selezionato è: " + evento.getTitolo() + " che si terrà il giorno: "
						+ evento.getDataEvento() + " con " + evento.getNumeroMassimoPartecipanti()
						+ " partecipanti e sarà " + evento.getTipoEvento());
			} catch (Exception e) {
				System.out.println("Errore durante il recupero dell'evento: " + e.getMessage());
			}
		}

		if (delete) {
			try {
				System.out.println("Inserisci l'id dell'evento da eliminare:");
				Scanner sc = new Scanner(System.in);
				int id = sc.nextInt();
				dao.delete(id);
				System.out.println("Evento numero " + id + " eliminato");
			} catch (Exception e) {
				System.out.println("Errore durante l'eliminazione dell'evento: " + e.getMessage());
			}
		}

		if (refresh) {
			try {
				int id = 1;
				Evento evento = dao.getById(id);
				dao.refresh(evento);
				System.out.println("Evento con id " + id + " aggiornato");
				System.out.println("Titolo: " + evento.getTitolo());
				System.out.println("Data evento: " + evento.getDataEvento());
				System.out.println("Descrizione: " + evento.getDescrizione());
				System.out.println("Tipo evento: " + evento.getTipoEvento());
				System.out.println("Numero massimo partecipanti: " + evento.getNumeroMassimoPartecipanti());
			} catch (Exception e) {
				System.out.println("Errore durante l'aggiornamento dell'evento: " + e.getMessage());
			}
		}

	}
}
