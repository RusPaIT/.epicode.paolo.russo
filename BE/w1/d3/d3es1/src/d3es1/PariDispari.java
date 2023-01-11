package d3es1;

public class PariDispari {
	
	 public static boolean controllo(String input) {
	        return (input.length() % 2 == 0);
	    }

	    public static void main(String[] args) {
	        String input = "testo di esempio";
	        System.out.println(controllo(input));
	    }

}
