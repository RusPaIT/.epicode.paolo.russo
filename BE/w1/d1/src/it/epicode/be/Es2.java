package it.epicode.be;

public class Es2 {
	
	public static void main (String[] args) {
		
	    //METODO MOLTIPLICA
		System.out.println(moltiplica(10,20));
		
		//METODO CONCATENA
		System.out.println(concatena(50));
		
		//METODO AGGIUNGI STRINGA IN ARRAY
		String[] a = new String[5];
		a[0] = "1";
		a[1] = "2";
		a[2] = "3";
		a[3] = "4";
		a[4] = "5";
		
		System.out.println(inserisciInArray(a, "6"));

		}

	static int moltiplica(int a, int b) {
		return a * b;
		
	}

	static String concatena(int b) {
		return ("Luca ha" + " " + b + " " + "anni");
	}

	public static String inserisciInArray(String[] a, String b) {
		
		
		String[] c = new String[6];
		

		c[0] = a[0];
		c[1] = a[1];
		c[2] = b;
		c[3] = a[2];
	    c[4] = a[3];
		c[5] = a[4];
		
		return java.util.Arrays.toString(c);
	}

}
