package d4;

import d4.Dipendente;


public class GestioneDipendenti {
	
	public static void main (String[] args) {
	
		
		        Dipendente dipendente1 = new Dipendente(1, "PRODUZIONE");
		        Dipendente dipendente2 = new Dipendente(2, "PRODUZIONE");
		        Dipendente dipendente3 = new Dipendente(3, "AMMINISTRAZIONE");
		        Dipendente dipendente4 = new Dipendente(4, "VENDITE");
		        
		        dipendente1.stampaDatiDipendente();
		        System.out.println("Nuovo livello: " + dipendente1.promuovi());
		        dipendente1.stampaDatiDipendente();
		        System.out.println("*                                   *");
		        System.out.println("*************************************");
		        System.out.println("*                                   *");
		        
		        dipendente2.stampaDatiDipendente();
		        System.out.println("*                                   *");
		        System.out.println("*************************************");
		        System.out.println("*                                   *");
		        
		        dipendente3.stampaDatiDipendente();
		        System.out.println("Nuovo livello: " + dipendente3.promuovi());
		        System.out.println("Nuovo livello: " + dipendente3.promuovi());
		        dipendente3.stampaDatiDipendente();
		        System.out.println("*                                   *");
		        System.out.println("*************************************");
		        System.out.println("*                                   *");
		        
		        dipendente4.stampaDatiDipendente();
		        System.out.println("Nuovo livello: " + dipendente4.promuovi());
		        System.out.println("Nuovo livello: " + dipendente4.promuovi());
		        System.out.println("Nuovo livello: " + dipendente4.promuovi());
		        dipendente4.stampaDatiDipendente();
		        System.out.println("*                                   *");
		        System.out.println("*************************************");
		        System.out.println("*                                   *");
		      
		        
				
		        
		        double paga1 = Dipendente.calcolaPaga(dipendente1);
		        double pagaConStraordinario1 = Dipendente.calcolaPaga(dipendente1, 5);
		        double paga2 = Dipendente.calcolaPaga(dipendente2);
		        double pagaConStraordinario2 = Dipendente.calcolaPaga(dipendente2, 5);
		        double paga3 = Dipendente.calcolaPaga(dipendente3);
		        double pagaConStraordinario3 = Dipendente.calcolaPaga(dipendente3, 5);
		        double paga4 = Dipendente.calcolaPaga(dipendente4);
		        double pagaConStraordinario4 = Dipendente.calcolaPaga(dipendente4, 5);

		        
		        
		       System.out.println("Stipendio mensile: " + paga1);
		       System.out.println("Stipendio mensile con straordinario: " + pagaConStraordinario1); 
		       System.out.println("*                                   *");
		       System.out.println("*************************************");
		       System.out.println("*                                   *");
		       
		       System.out.println("Stipendio mensile: " + paga2);
		       System.out.println("Stipendio mensile con straordinario: " + pagaConStraordinario3); 
		       System.out.println("*                                   *");
		       System.out.println("*************************************");
		       System.out.println("*                                   *");
		        
		       System.out.println("Stipendio mensile: " + paga3);
		       System.out.println("Stipendio mensile con straordinario: " + pagaConStraordinario3); 
		       System.out.println("*                                   *");
		       System.out.println("*************************************");
		       System.out.println("*                                   *");
		       
		       System.out.println("Stipendio mensile: " + paga4);
		       System.out.println("Stipendio mensile con straordinario: " + pagaConStraordinario4); 
		       System.out.println("*                                   *");
		       System.out.println("*************************************");
		       System.out.println("*                                   *");
		    }

		
	}


