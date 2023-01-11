package d3es3;

import java.util.Scanner;

public class DividiStringa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Inserisci una stringa (:q per uscire): ");
            String input = scanner.nextLine();

            if (input.equals(":q")) {
                break;
            }

            String[] caratteri = input.split("");
            String caratteriSeparati = String.join(",", caratteri);
            System.out.println(caratteriSeparati);
        }
    }
}

