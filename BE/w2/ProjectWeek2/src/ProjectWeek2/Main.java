package ProjectWeek2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Catalogo catalogo = new Catalogo();
		catalogo.addLibro(
				new Libro("123-4-56-789012-3", "Il Signore degli Anelli", 1954, 456, "J.R.R. Tolkien", "Fantasy"));
		catalogo.addLibro(new Libro("987-6-54-321098-7", "Harry Potter e la Pietra Filosofale", 1997, 256,
				"J.K. Rowling", "Fantasy"));
		catalogo.addLibro(
				new Libro("456-7-89-012345-6", "Il Piccolo Principe", 1943, 152, "Antoine de Saint-Exupéry", "Fiaba"));
		catalogo.addRivista(new Rivista("111-2-33-444556-6", "National Geographic", 1887, 72, Periodicità.MENSILE));
		catalogo.addRivista(new Rivista("222-3-44-556677-7", "Science", 1880, 100, Periodicità.SETTIMANALE));
		catalogo.addRivista(new Rivista("333-4-55-667788-8", "Nature", 1869, 50, Periodicità.SEMESTRALE));

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Menu principale:");
			System.out.println("1) Aggiungi elemento");
			System.out.println("2) Rimuovi elemento");
			System.out.println("3) Ricerca per codice ISBN");
			System.out.println("4) Ricerca per anno di pubblicazione");
			System.out.println("5) Ricerca per autore");
			System.out.println("6) Salva archivio");
			System.out.println("7) Carica archivio");
			System.out.println("8) Esci");
			int scelta = scanner.nextInt();
			scanner.nextLine();
			switch (scelta) {
			case 1:
				catalogo.addItemUtente();
				break;
			case 2:
				System.out.print("Inserire il codice ISBN dell'elemento da rimuovere: ");
				String ISBN = scanner.nextLine();
				catalogo.removeByISBN(ISBN);
				break;
			case 3:
				while (true) {
					System.out.println("Inserisci il codice ISBN per la ricerca o 'esc' per uscire:");
					String ISBN1 = scanner.nextLine();
					if (ISBN1.equals("esc")) {
						break;
					}
					List<Object> searchResults = catalogo.searchByISBN(ISBN1);
					if (searchResults.isEmpty()) {
						System.out.println("Nessun elemento trovato per il codice ISBN specificato.");
					} else {
						for (Object item : searchResults) {
							System.out.println(item);
						}
					}
				}
				break;
			case 4:
				while (true) {
					System.out.println("Inserisci l'anno di pubblicazione per la ricerca o 'esc' per uscire:");
					String input = scanner.nextLine();
					if (input.equals("esc")) {
						break;
					}
					int year;
					try {
						year = Integer.parseInt(input);
					} catch (NumberFormatException e) {
						System.out.println("Formato non valido, inserire un numero intero.");
						continue;
					}
					List<Object> searchResults = catalogo.searchByYear(year);
					if (searchResults.isEmpty()) {
						System.out.println("Nessun elemento trovato per l'anno di pubblicazione specificato.");
					} else {
						for (Object item : searchResults) {
							System.out.println(item);
						}
					}
				}
				break;
			case 5:
				while (true) {
					System.out.println("Inserisci il nome dell'autore per la ricerca o 'esc' per uscire:");
					String author = scanner.nextLine();
					if (author.equals("esc")) {
						break;
					}
					List<Libro> searchResults = catalogo.searchByAuthor(author);
					if (searchResults.isEmpty()) {
						System.out.println("Nessun elemento trovato per l'autore specificato.");
					} else {
						for (Object item : searchResults) {
							System.out.println(item);
						}
					}
				}
				break;
			case 6:
				try {
					catalogo.salvaArchivio();
					System.out.println("Archivio salvato con successo.");
				} catch (IOException e) {
					System.out.println("Errore durante il salvataggio dell'archivio: " + e.getMessage());
				}
				break;
			case 7:
				File archivioFile = new File("archivio.txt");
			    if (!archivioFile.exists()) {
			        System.out.println("Il file archivio non esiste, crealo prima di caricarlo.");
			        break;
			    }
			    try {
			        catalogo.caricaArchivio();
			        System.out.println("Archivio caricato con successo.");
			    } catch (IOException e) {
			        System.out.println("Errore durante il caricamento dell'archivio: " + e.getMessage());
			    }
			    break;
			case 8:
				return;
				default:
				System.out.println("Scelta non valida, riprovare.");
				break;
			}
		}
	}
}
