package d2es2;

public class es2 {

	public static void main(String[] args) {
		Sim miaSim = new Sim("+39 320 9999999");
		
		miaSim.setCreditoDisponibile(10);
		
		Chiamata chiamata = new Chiamata("+39 333 5566778", 3);
		miaSim.getListaChiamate()[0] = chiamata;
		
		chiamata = new Chiamata("+39 333 5566779", 5);
		miaSim.getListaChiamate()[1] = chiamata;
		
		chiamata = new Chiamata("+39 333 5566770", 7);
		miaSim.getListaChiamate()[2] = chiamata;
		
		miaSim.stampaDati();
	}
}
