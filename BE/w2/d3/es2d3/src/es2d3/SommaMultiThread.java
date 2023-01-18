package es2d3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SommaMultiThread {
	static int[] valori = new int[3000];
	static int[] sommaParziale = new int[3];
	static List<Thread> thread = new ArrayList<Thread>();

	public static void main(String[] args) {
		Random random = new Random();

		// Genera valori casuali per l'array
		for (int i = 0; i < valori.length; i++) {
			valori[i] = random.nextInt();
		}

		// Crea e avvia i thread
		for (int i = 0; i < 3; i++) {
			final int indiceThread = i;
			thread.add(new Thread(new SommaThreadWorker(valori, sommaParziale, indiceThread)));
			thread.get(i).start();
		}

		// Aspetta la terminazione dei thread
		for (int i = 0; i < thread.size(); i++) {
			try {
				thread.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Somma le somme parziali e stampa il risultato
		int sommaTotale = 0;
		for (int i = 0; i < 3; i++) {
			sommaTotale += sommaParziale[i];
		}
		System.out.println("Somma totale Thread: " + sommaTotale);
	}
}
