package utils;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Concerto;
import entities.Evento;
import entities.EventoDAO;
import entities.GaraDiAtletica;
import entities.Genere;
import entities.Location;
import entities.LocationDAO;
import entities.Partecipazione;
import entities.PartecipazioneDAO;
import entities.PartitaDiCalcio;
import entities.Persona;
import entities.PersonaDAO;
import entities.Sesso;
import entities.TipoEvento;

public class JpaUtil {

	private static final String persistenceUnit = "w3d4";
	public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
	public static final EntityManager em = emf.createEntityManager();
	public static final EntityTransaction t = em.getTransaction();

	
	public static void main(String[] args) {

		EventoDAO dao = new EventoDAO();
		GaraDiAtletica gara = new GaraDiAtletica();
		Concerto concerto = new Concerto();
		PersonaDAO personaDAO = new PersonaDAO();
		Persona persona = new Persona();
		PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();
		LocationDAO locationDAO = new LocationDAO();
		Location location = new Location();
    	PartitaDiCalcio dao1 = new PartitaDiCalcio();
    	
    	boolean garasalvata = false;
    	boolean partite = false;
		boolean risultati = false;
		boolean stream = false;
		boolean generiFiltrati = false;
		boolean savep = false;
		boolean savec = false;
		boolean save = false;
		boolean getById = false;
		boolean delete = false;
		boolean refresh = false;
		
		
		/*Set<GaraDiAtletica> gare = dao.getGareDiAtleticaPerVincitore(1);
		for (GaraDiAtletica gara1 : gare) {
		    System.out.println(gara1);
		}*/
		
		if (garasalvata) {
		gara.setTitolo("Gara di atletica delle scuole superiori");
		gara.setDataEvento(LocalDate.of(2022, 06, 20));
		gara.setDescrizione("Gara di atletica per studenti delle scuole superiori");
		gara.setTipoEvento(TipoEvento.PRIVATO);
		gara.setNumeroMassimoPartecipanti(10);

		gara.save();
		}
		
		
		if(partite) {
		}
		if (risultati) {
		List<PartitaDiCalcio> partiteVinteInCasa = dao.getPartiteVinteInCasa();
		for (PartitaDiCalcio partita : partiteVinteInCasa) {
			System.out.println(partita.getSquadraCasa() + " ha vinto contro " + partita.getSquadraOspite());
			}
		List<PartitaDiCalcio> partiteVinteInTrasferta = dao.getPartiteVinteInTrasferta();
		for (PartitaDiCalcio partita : partiteVinteInTrasferta) {
			System.out.println(partita.getSquadraOspite() + " ha vinto contro " + partita.getSquadraCasa());
			}
		List<PartitaDiCalcio> partitePareggiate = dao.getPartitePareggiate();
		for (PartitaDiCalcio partita : partitePareggiate) {
			System.out.println("Partita finita in pareggio tra " + partita.getSquadraCasa() + " e " + partita.getSquadraOspite());
			}
		}
		
		
		if (stream) {
			try {
			    List<Concerto> concerti = dao.getConcertiInStreaming(false);
			    for (Concerto concerto1 : concerti) {
			        System.out.println(concerto1.getTitolo() + " - " + concerto1.getDataEvento() + " - " + concerto1.getGenere() + " - " + concerto1.isInStreaming());
			    }
			} catch (Exception e) {
			    System.out.println("Errore durante il recupero dei concerti in streaming: " + e.getMessage());
			}

		}

		if(generiFiltrati) {
		List<Genere> generi = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Scegli il genere per visualizzare i concerti (CLASSICO, ROCK, POP): ");
		String genere = scanner.nextLine();
		while (!genere.equals("fine")) {
		    try {
		        generi.add(Genere.valueOf(genere));
		    } catch (IllegalArgumentException e) {
		        System.out.println("Genere non valido. Inserire CLASSICO, ROCK o POP.");
		    }
		    System.out.println("Scegli il genere per visualizzare i concerti (CLASSICO, ROCK, POP) o digitare 'fine' per terminare: ");
		    genere = scanner.nextLine();
		}
		List<Concerto> concertiPerGenere = dao.getConcertiPerGenere(generi);
		System.out.println("Concerti per genere:");
		for (Concerto concerto2 : concertiPerGenere) {
		    System.out.println(concerto2.getTitolo() + " " + concerto2.getGenere());
		}
		}


		if (savep) {
			try {
				   persona.setNome("Gesù");
				    persona.setCognome("Cristo");
				    persona.setEmail("iamj@gmail.com");
				    persona.setDataNascita(LocalDate.of(0000, 12, 25));
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
