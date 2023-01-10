package it.epicode.be;

import java.util.Scanner;

public class Es3 {
	

	public static void main (String[] args) {
		//STRINGHE AGGIUNTE DA USER
		Scanner in = new Scanner(System.in);
		String[] stringhe = new String[3];
		
		System.out.println("Forma una frase di tre parole");
		System.out.println("Prima parola:");
		stringhe[0] = in.nextLine();
		System.out.println("Seconda parola:");
		stringhe[1] = in.nextLine();
		System.out.println("Terza parola:");
		stringhe[2] = in.nextLine();
		
		System.out.println("frase in ordine: ");
		System.out.println(stringhe[0] + " " + stringhe[1] + " " + stringhe[2]);
		
		System.out.println("frase in ordine inverso: ");
		System.out.println(stringhe[2] + " " + stringhe[1] + " " + stringhe[0]);
		in.close();
	}

}
