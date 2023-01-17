package es1d2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        Set<String> words = new HashSet<>();
        Set<String> duplicateWords = new HashSet<>();

        System.out.print("Inserire il numero di elementi da inserire: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Inserire una parola: ");
            String word = scanner.next();
            if (!words.add(word)) {
                duplicateWords.add(word);
            }
        }

        System.out.println("Parole duplicate: " + duplicateWords);
        System.out.println("Numero di parole distinte: " + words.size());
        System.out.println("Elenco delle parole distinte: " + words);

        scanner.close();
    }
}

