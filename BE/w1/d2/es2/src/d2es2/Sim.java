package d2es2;

public class Sim {
	private String numeroTelefono;
	private double creditoDisponibile;
	private Chiamata[] listaChiamate;
	
	public Sim(String numero) {
		this.numeroTelefono = numero;
		this.creditoDisponibile = 0;
		this.listaChiamate = new Chiamata[5];
	}
	
	public String getNumeroTelefono() {
		return numeroTelefono;
		
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public Chiamata[] getListaChiamate() {
		return listaChiamate;
	}

	public void setListaChiamate(Chiamata[] listaChiamate) {
		this.listaChiamate = listaChiamate;
	}

	public double getCreditoDisponibile() {
		return creditoDisponibile;
	}

	public void setCreditoDisponibile(double creditoDisponibile) {
		this.creditoDisponibile = creditoDisponibile;
	}
	
	public void stampaDati() {
		System.out.println("Sim: " + this.numeroTelefono);
		System.out.println("Credito disponibile: " + this.creditoDisponibile);
		System.out.println("Lista chiamate Sim:" + this.numeroTelefono);
	}

}
