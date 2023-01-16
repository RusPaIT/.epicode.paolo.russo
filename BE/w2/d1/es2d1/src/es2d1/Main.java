package es2d1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Inserisci i km percorsi: ");
            double km = sc.nextDouble();

            System.out.print("Inserisci i litri di carburante consumati: ");
            double litri = sc.nextDouble();

            if (litri == 0) {
                throw new ArithmeticException("Divisione per zero non consentita");
            }

            double kmPerLitro = km / litri;
            System.out.println("Km/Litro: " + kmPerLitro);

        } catch (ArithmeticException e) {
            System.out.println("Errore: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}

