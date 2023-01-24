package utils;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Evento;
import entities.EventoDAO;
import entities.TipoEvento;

public class JpaUtil {

	private static final String persistenceUnit = "w3d2";
	public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
	public static final EntityManager em = emf.createEntityManager();
	public static final EntityTransaction t = em.getTransaction();

	public static void main(String[] args) {

		EventoDAO dao = new EventoDAO();

		boolean save = false;
		boolean getById = false;
		boolean delete = false;
		boolean refresh = true;

		if (save) {
			try {
				Evento evento = new Evento("Festa di compleanno", LocalDate.of(2022, 12, 25),
						"Festa di compleanno con amici e familiari", TipoEvento.PRIVATO, 50);

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
