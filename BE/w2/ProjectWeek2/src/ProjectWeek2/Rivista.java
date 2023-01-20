package ProjectWeek2;

class Rivista {
    private String codiceISBN;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;
    private Periodicità periodicità;

    public Rivista(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
        this.periodicità = periodicità;
    }
    
    public String toString() {
        return "Rivista [codiceISBN = " + codiceISBN + ", titolo = " + titolo + ", annoPubblicazione = " + annoPubblicazione + ", numeroPagine = " + numeroPagine + ", periodicità = " + periodicità + "]";
    }

    //GETTERS
    public String getCodiceISBN() {
        return codiceISBN;
    }
    
    public String getTitolo() {
        return titolo;
    }
    
    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }
    
    public int getNumeroPagine() {
        return numeroPagine;
    }
    

    public Periodicità getPeriodicità() {
        return periodicità;
    }
    
    //SETTERS
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    
    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }
    
    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
    
    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }
}
