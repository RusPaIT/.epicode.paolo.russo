package projectWeek;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LettoreMultimediale lettore = new LettoreMultimediale();

        // Creazione degli elementi multimediali
        for (int i = 0; i < 5; i++) {
            System.out.print("Inserisci il titolo dell'elemento multimediale " + (i + 1) + ": ");
            String titolo = scanner.nextLine();
            System.out.print("Inserisci il tipo dell'elemento multimediale (immagine, audio o video): ");
            String tipo = scanner.nextLine();
            if (tipo.equalsIgnoreCase("immagine")) {
                System.out.print("Inserisci la luminosità dell'immagine: ");
                int luminosita = scanner.nextInt();
                scanner.nextLine();
                lettore.aggiungiElemento(new Immagine(titolo, luminosita));
            } else if (tipo.equalsIgnoreCase("audio")) {
                System.out.print("Inserisci il volume dell'audio: ");
                int volume = scanner.nextInt();
                System.out.print("Inserisci la durata dell'audio: ");
                int durata = scanner.nextInt();
                scanner.nextLine();
                lettore.aggiungiElemento(new Audio(titolo, volume, durata));
            } else if (tipo.equalsIgnoreCase("video")) {
                System.out.print("Inserisci il volume del video: ");
                int volume = scanner.nextInt();
                System.out.print("Inserisci la durata del video: ");
                int durata = scanner.nextInt();
                System.out.print("Inserisci la luminosità del video: ");
                int luminosita = scanner.nextInt();
                scanner.nextLine();
                lettore.aggiungiElemento(new Video(titolo, luminosita, durata, volume));
            } else {
                System.out.println("Tipo non valido");
                i--;
            }
        }

        // Esecuzione degli elementi multimediali
        int scelta;
        do {
            System.out.print("Inserisci il numero dell'elemento multimediale da eseguire (1-5) o 0 per uscire: ");
            scelta = scanner.nextInt();
            scanner.nextLine();
            if (scelta >= 1 && scelta <= 5) {
                lettore.eseguiElemento(scelta - 1);
            } else if (scelta != 0) {
                System.out.println("Scelta non valida");
            }
        } while (scelta != 0);
        }
    }


