package it.epicode.be;

import java.util.Scanner;

public class Es4 {
	

	public static void main (String[] args) {
		
		//AREA RETTANGOLO
		Scanner in = new Scanner(System.in);
		System.out.println("Inserisci la base del rettangolo");
		double base = in.nextDouble();
		System.out.println("Inserisci l' altezza del rettangolo");
		double altezza = in.nextDouble();
		System.out.println("L' area del rettangolo è: " + areaRettangolo(base, altezza));
		
		//PARI E DISPARI
		System.out.println("Inserisci un numero, se esce 0 è pari se esce 1 è dispari");
		int n = in.nextInt();
		System.out.println(pariDispari(n));
		
		//AREA TRIANGOLO
		System.out.println("Inserisci la base del triangolo");
		double baseTriangolo = in.nextDouble();
		System.out.println("Inserisci l' altezza del triangolo");
		double altezzaTriangolo = in.nextDouble();
		System.out.println(areaTriangolo(baseTriangolo, altezzaTriangolo));
		
		in.close();
		
	}
	
	public static double areaRettangolo(double base, double altezza) {
		return base * altezza;
	}
	
	public static int pariDispari(int n) {
		if((n % 2) == 0) {
			return 0;
		}else {
			return 1;
		}
	}
	
	public static double areaTriangolo(double baseTriangolo, double altezzaTriangolo) {
		return baseTriangolo * altezzaTriangolo / 2;
	}


}
