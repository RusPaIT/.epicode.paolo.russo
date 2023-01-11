package d3es2;

import java.util.Scanner;

public class NumeroInLettere {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un numero intero (0-3): ");
        int num = scanner.nextInt();

        switch (num) {
            case 0:
                System.out.println("zero");
                break;
            case 1:
                System.out.println("uno");
                break;
            case 2:
                System.out.println("due");
                break;
            case 3:
                System.out.println("tre");
                break;
            default:
                System.out.println("Numero non valido. Inserisci un numero tra 0 e 3.");
                break;
        }
    }
}
