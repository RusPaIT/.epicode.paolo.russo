package ProjectWeek2;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

import java.io.File;

class Catalogo {
	static File fileInfo= new File("archivio.txt");
	private static final String ENCODING = "utf-8";

	private List<Libro> libri = new ArrayList<>();
	private List<Rivista> riviste = new ArrayList<>();
	private Consumer<String> addToArchive = (line) -> {
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("archivio.txt", true)))) {
			out.println(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	};

	public void addLibro(Libro libro) {
		libri.add(libro);
		addToArchive.accept(libro.toString());
	}

	public void addRivista(Rivista rivista) {
		riviste.add(rivista);
		addToArchive.accept(rivista.toString());
	}

	//AGGIUNGE ELEMENTO
	public void addItemUtente() {
		Scanner scanner = new Scanner(System.in);
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
				Libro libro = new Libro(codiceISBN, titolo, annoPubblicazione, numeroPagine, autore, genere);
				libri.add(libro);
				addToArchive.accept(libro.toString());
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
				Rivista rivista = new Rivista(codiceISBN, titolo, annoPubblicazione, numeroPagine, periodicità);
				riviste.add(rivista);
				addToArchive.accept(rivista.toString());
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

	//RIMUOVE ELEMENTO
	public void removeByISBN(String ISBN) {
		boolean removed = libri.removeIf(libro -> libro.getCodiceISBN().equals(ISBN));
		if (!removed) {
			removed = riviste.removeIf(rivista -> rivista.getCodiceISBN().equals(ISBN));
		}
		if (removed) {
			System.out.println("Elemento rimosso con successo!, nuovo catalogo: " + libri);
		} else {
			System.out.println("Elemento non trovato!");
		}
	}

	
	//CERCA ELEMENTO TRAMITE CODICE ISBN
	public List<Object> searchByISBN(String ISBN) {
		List<Object> items = new ArrayList<>();
		items.addAll(libri.stream().filter(l -> l.getCodiceISBN().equals(ISBN)).collect(Collectors.toList()));
		items.addAll(riviste.stream().filter(r -> r.getCodiceISBN().equals(ISBN)).collect(Collectors.toList()));
		return items;
	}

	//CERCA ELEMENTO TRAMITE ANNO
	public List<Object> searchByYear(int year) {
		List<Object> items = new ArrayList<>();
		items.addAll(libri.stream().filter(l -> l.getAnnoPubblicazione() == year).collect(Collectors.toList()));
		items.addAll(riviste.stream().filter(r -> r.getAnnoPubblicazione() == year).collect(Collectors.toList()));
		return items;
	}

	//CERCA ELEMENTO TRAMITE AUTORE
	public List<Libro> searchByAuthor(String author) {
		return libri.stream().filter(l -> l.getAutore().equalsIgnoreCase(author)).collect(Collectors.toList());
	}
	
	//SALVATAGGIO SU ARCHIVIO
	public void salvaArchivio() throws IOException {
	    FileWriter fileWriter = new FileWriter("archivio.txt");
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    for (Libro libro : libri) {
	        printWriter.println(libro.toString());
	    }
	    for (Rivista rivista : riviste) {
	        printWriter.println(rivista.toString());
	    }
	    printWriter.close();
	    fileWriter.close();
	}
    
	//CARICAMENTO DA ARCHIVIO
	public void caricaArchivio() throws IOException {
	    FileReader fileReader = new FileReader("archivio.txt");
	    BufferedReader bufferedReader = new BufferedReader(fileReader);
	    String line;
	    while ((line = bufferedReader.readLine()) != null) {
	        String[] elementi = line.split(",");
	        if(elementi[0].equals("Libro"))
	            libri.add(new Libro(elementi[1], elementi[2], Integer.parseInt(elementi[3]), Integer.parseInt(elementi[4]), elementi[5], elementi[6]));
	        else
	            riviste.add(new Rivista(elementi[1], elementi[2], Integer.parseInt(elementi[3]), Integer.parseInt(elementi[4]), Periodicità.valueOf(elementi[5])));
	    }
	    bufferedReader.close();
	    fileReader.close();
	}

}
