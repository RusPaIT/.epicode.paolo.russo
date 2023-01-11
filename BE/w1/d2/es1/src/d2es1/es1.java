package d2es1;

import java.util.Scanner;

public class es1 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("****    Due rettangoli    ****");
		System.out.println("*                            *");
		System.out.println("* Inserire la lunghezza del rettangolo 1 *");
		System.out.println("*                            *");
		double lunghezza1 = in.nextDouble();
		System.out.println("*                            *");
		System.out.println("* Inserire la larghezza del rettangolo 1   *");
		System.out.println("*                            *");
		double larghezza1 = in.nextDouble();
		System.out.println("*                            *");
		System.out.println("* Inserire la lunghezza del rettangolo 2   *");
		System.out.println("*                            *");
		double lunghezza2 = in.nextDouble();
		System.out.println("*                            *");
		System.out.println("* Inserire la larghezza del rettangolo 2   *");
		System.out.println("*                            *");
		double larghezza2 = in.nextDouble();
		
		Rettangolo rettangolo1 = new Rettangolo(lunghezza1, larghezza1);
		System.out.println("Rettangolo 1");
		stampaRettangolo(rettangolo1);
		
		Rettangolo rettangolo2 = new Rettangolo(lunghezza2, larghezza2);
		System.out.println("Rettangolo 2");
		
		stampaDueRettangoli(rettangolo1, rettangolo2);
		
		in.close();
	}
	
	public static void stampaRettangolo(Rettangolo rettangolo) {
		System.out.println("Perimetro rettangolo: " + rettangolo.perimetro());
		System.out.println("Area rettangolo: " + rettangolo.area());
	}
	
	public static void stampaDueRettangoli(Rettangolo rettangolo1, Rettangolo rettangolo2) {
		System.out.println("Rettangolo1: ");
		stampaRettangolo(rettangolo1);
		
		System.out.println("Rettangolo2: ");
		stampaRettangolo(rettangolo2);
		
		double sommaArea = rettangolo1.area() + rettangolo2.area();
		double sommaPerimetro = rettangolo1.perimetro() + rettangolo2.perimetro();
		
		System.out.println("Somma perimetri: ");
		System.out.println(sommaPerimetro);
		System.out.println("Somma aree: ");
		System.out.println(sommaArea);
	}
	

}
