package utlis;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import entities.Prestito;
import entities.Utente;

public class Main {

	public static void main(String[] args) {

		CatalogoDAO dao = new CatalogoDAO();
		List<Prestito> prestitiScaduti = dao.prestitiScaduti();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Menu principale:");
			System.out.println("1) Aggiungi elemento");
			System.out.println("2) Rimuovi elemento");
			System.out.println("3) Ricerca per codice ISBN");
			System.out.println("4) Ricerca per anno di pubblicazione");
			System.out.println("5) Ricerca per autore");
			System.out.println("6) Ricerca per titolo o parte di esso");
			System.out.println("7) Ricerca elementi attualmente in prestito tramite codice tessera utente");
			System.out.println("8) Ricerca di tutti i prestiti scaduti e non ancora restituiti");
			System.out.println("9) Esc");
			
			int scelta = scanner.nextInt();
			scanner.nextLine();
			switch (scelta) {
			case 1:
				dao.addItemUtente();
				break;
			case 2:
				dao.deleteByISBN();
				break;
			case 3:
				while (true) {
					dao.cercaPerISBN("");
				}
				
			case 4:
				while (true) {
					dao.cercaPerAnnoPubblicazione();
				}
				
			case 5:
				while (true) {
					dao.cercaPerAutore();
				}
			case 6:
				 {
					dao.cercaPerTitolo();
				}
				break;
			case 7:
				{
					dao.cercaPrestitiPerUtente();
			    }
			    break;
			case 8:{
				for (Prestito prestito : prestitiScaduti) {
				    System.out.println(prestito);}
			}
			case 9: 
				return;
				default:
				System.out.println("Scelta non valida, riprovare.");
				break;
			}
		}
		
		
		
		
	}

}