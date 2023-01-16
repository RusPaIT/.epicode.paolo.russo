package es3d1;

public class ContoCorrente {

	String titolare;
	int nMovimenti;
	final int maxMovimenti = 50;
	double saldo;

	ContoCorrente(String titolare, double saldo) {
		this.titolare = titolare;
		this.saldo = saldo;
		nMovimenti = 0;
	}

	 void preleva(double x) throws BancaException {
	        double saldoDopoPrelievo = saldo - x;
	        if (saldoDopoPrelievo < 0) {
	            throw new BancaException("Il conto è in rosso");
	        } else if (nMovimenti < maxMovimenti) {
	            saldo = saldoDopoPrelievo;
	        } else {
	            saldo = saldoDopoPrelievo - 0.50;
	        }
	        nMovimenti++;
	    }

	double restituisciSaldo() {
		return saldo;
	}
}

