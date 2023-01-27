package utlis;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import entities.Catalogo;

import entities.Libro;
import entities.Periodicità;
import entities.Prestito;
import entities.Rivista;
import entities.Utente;

public class CatalogoDAO {

	private static final String persistenceUnit = "projectWeek3";
	public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
	public static final EntityManager em = emf.createEntityManager();
	public static final EntityTransaction t = em.getTransaction();
	Scanner scanner = new Scanner(System.in);

	public void addItemUtente() {

		try {
			System.out.println("Vuoi aggiungere un libro o una rivista? (libro/rivista)");
			String itemType = scanner.nextLine();
			if (itemType.equalsIgnoreCase("libro")) {
				System.out.println("Inserisci il codice ISBN:");
				String codiceISBN = scanner.nextLine();
				System.out.println("Inserisci il titolo:");
				String titolo = scanner.nextLine();
				System.out.println("Inserisci l'anno di pubblicazione:");
				int annoPubblicazione = scanner.nextInt();
				System.out.println("Inserisci il numero di pagine:");
				int numeroPagine = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Inserisci l'autore:");
				String autore = scanner.nextLine();
				System.out.println("Inserisci il genere:");
				String genere = scanner.nextLine();
				Libro libro = new Libro();
				libro.setISBN(codiceISBN);
				libro.setTitolo(titolo);
				libro.setAnnoPubblicazione(annoPubblicazione);
				libro.setNumeroPagine(numeroPagine);
				libro.setAutore(autore);
				libro.setGenere(genere);
				t.begin();
				em.persist(libro);
				t.commit();

			} else if (itemType.equalsIgnoreCase("rivista")) {
				System.out.println("Inserisci il codice ISBN:");
				String codiceISBN = scanner.nextLine();
				System.out.println("Inserisci il titolo:");
				String titolo = scanner.nextLine();
				System.out.println("Inserisci l'anno di pubblicazione:");
				int annoPubblicazione = scanner.nextInt();
				System.out.println("Inserisci il numero di pagine:");
				int numeroPagine = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Inserisci la periodicità (SETTIMANALE, MENSILE, SEMESTRALE):");
				Periodicità periodicità = Periodicità.valueOf(scanner.nextLine());
				Rivista rivista = new Rivista();
				rivista.setISBN(codiceISBN);
				rivista.setTitolo(titolo);
				rivista.setAnnoPubblicazione(annoPubblicazione);
				rivista.setNumeroPagine(numeroPagine);
				rivista.setPeriodicita(periodicità);
				t.begin();
				em.persist(rivista);
				t.commit();
			} else {
				System.out.println("Tipo di elemento non valido.");
			}
		} catch (InputMismatchException e) {
			System.out.println(
					"Errore di input, inserire un valore numerico per l'anno di pubblicazione e il numero di pagine.");
		} catch (IllegalArgumentException e) {
			System.out.println("Periodicità non valida, inserire una tra SETTIMANALE, MENSILE, SEMESTRALE.");
		}

	}

	public void deleteByISBN() {
		System.out.println("Inserisci il codice ISBN:");
		String codiceISBN = scanner.nextLine();
		t.begin();
		Catalogo item = em.find(Catalogo.class, codiceISBN);
		em.remove(item);
		t.commit();
		em.close();
	}

	public Catalogo cercaPerISBN(String string) {
		Catalogo item = null;
		try {
			t.begin();
			javax.persistence.Query query = em.createQuery("FROM Catalogo WHERE ISBN = :isbn");
			System.out.println("Inserisci il codice ISBN");
			String codiceISBN = scanner.nextLine();
			query.setParameter("isbn", codiceISBN);
			item = (Catalogo) query.getSingleResult();
			t.commit();
			System.out.println(item);
		} catch (NoResultException e) {
			System.out.println("Nessun elemento trovato per il codice ISBN specificato.");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	public Catalogo cercaPerAnnoPubblicazione() {
		Catalogo item = null;
		try {
			t.begin();
			javax.persistence.Query query = em
					.createQuery("FROM Catalogo WHERE annoPubblicazione = :annoPubblicazione");
			System.out.println("Inserisci l'anno di pubblicazione");
			int anno = scanner.nextInt();
			query.setParameter("annoPubblicazione", anno);
			item = (Catalogo) query.getSingleResult();
			t.commit();
			System.out.println(item);
		} catch (NoResultException e) {
			System.out.println("Nessun elemento trovato per l'anno di pubblicazione specificato.");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	public Catalogo cercaPerAutore() {
		Catalogo item = null;
		try {
			t.begin();
			javax.persistence.Query query = em.createQuery("FROM Catalogo WHERE Autore = :autore");
			System.out.println("Inserisci il nome dell'autore");
			String nomeAutore = scanner.nextLine();
			query.setParameter("autore", nomeAutore);
			item = (Catalogo) query.getSingleResult();
			t.commit();
			System.out.println(item);
		} catch (NoResultException e) {
			System.out.println("Nessun elemento trovato per l'autore specificato.");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	public List<Catalogo> cercaPerTitolo() {
		List<Catalogo> items = null;
		try {
			t.begin();
			javax.persistence.Query query = em.createQuery("FROM Catalogo WHERE titolo LIKE :titolo");
			System.out.println("Inserisci il nome del titolo o parte di esso");
			String titolo = scanner.nextLine();
			query.setParameter("titolo", "%" + titolo + "%");
			items = query.getResultList();
			t.commit();
			System.out.println(items);
		} catch (NoResultException e) {
			System.out.println("Nessun elemento trovato per il titolo specificato.");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Catalogo item : items) {
			System.out.println(item);
		}
		return null;
	}

	public static void addUtente(Utente utente) {

		try {
			t.begin();
			em.persist(utente);
			t.commit();
			em.close();
		} catch (Exception e) {
			t.rollback();
			throw e;
		}

	}

	public Utente trovaPerNumeroTessera(String string) {
		Utente utente = null;
		try {
			t.begin();
			System.out.println("Inserisci il codice tessera Utente:");
			String codiceTessera = scanner.nextLine();
			Query query = (Query) em.createQuery("FROM Utente WHERE numeroTessera = :numeroTessera");
			((javax.persistence.Query) query).setParameter("numeroTessera", codiceTessera);
			utente = (Utente) ((javax.persistence.Query) query).getSingleResult();
			t.commit();
		} catch (NoResultException e) {
			System.out.println("Nessun utente trovato con questo numero di tessera.");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return utente;
	}

	public List<Catalogo> cercaPrestitiPerUtente() {
		List<Catalogo> prestiti = new ArrayList<>();
		try {
			System.out.println("Inserisci il codice tessera Utente:");
			String codiceTessera = scanner.nextLine();
			t.begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Catalogo> cq = cb.createQuery(Catalogo.class);
			Root<Prestito> root = cq.from(Prestito.class);
			cq.select(root.get("catalogo"));
			cq.where(cb.and(cb.equal(root.get("utente").get("numeroTessera"), codiceTessera),
					cb.isNull(root.get("dataRestituzioneEffettiva"))));
			prestiti = em.createQuery(cq).getResultList();
			t.commit();
			System.out.println(prestiti);
		} catch (NoResultException e) {
			System.out.println("Nessun prestito trovato per il numero di tessera specificato.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prestiti;
	}

	public List<Prestito> prestitiScaduti() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Prestito> criteria = builder.createQuery(Prestito.class);
		Root<Prestito> prestito = criteria.from(Prestito.class);
		LocalDate dataCorrente = LocalDate.now();
		criteria.select(prestito)
				.where(builder.and(builder.lessThanOrEqualTo(prestito.get("dataRestituzionePrevista"), dataCorrente),
						builder.isNull(prestito.get("dataRestituzioneEffettiva"))));
		TypedQuery<Prestito> q = em.createQuery(criteria);
		List<Prestito> prestitiScadutiNonRestituiti = q.getResultList();
		em.close();
		return prestitiScadutiNonRestituiti;
	}
}
