package es1d1;

import java.util.Random;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
	  
    int[] array = new int[5];
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);

    // generazione di valori casuali e stampa dell'array
    
    for (int i = 0; i < array.length; i++) {
      array[i] = rand.nextInt(10) + 1;
      System.out.print(array[i] + " ");
    }
    System.out.println();

    int input = 0;
    do {
    	
      // chiedere all'utente di inserire un numero e posizione
    	
      System.out.print("Inserisci un numero: ");
      try {
        input = sc.nextInt();
        if (input != 0) {
          System.out.print("Inserisci una posizione (0-4): ");
          int pos = sc.nextInt();

          // verifica dei limiti dell'array
          
          if (pos < 0 || pos >= array.length) {
            System.out.println("Posizione non valida. Riprova.");
          } else {
        	  
            // sostituzione del valore nell'array
        	  
            array[pos] = input;
            
            // stampa del nuovo stato dell'array
            
            for (int i = 0; i < array.length; i++) {
              System.out.print(array[i] + " ");
            }
            System.out.println();
          }
        }
      } catch (NumberFormatException e) {
        System.out.println("Input non valido. Riprova.");
        sc.nextLine();
      }
    } while (input != 0);
    sc.close();
  }
}
