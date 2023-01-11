package d3es4;

import java.util.Scanner;

public class ContoAllaRovescia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un numero intero: ");
        int num = scanner.nextInt();

        for (int i = num; i >= 0; i--) {
            System.out.println(i);
        }
    }
}
