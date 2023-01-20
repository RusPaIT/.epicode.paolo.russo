package ProjectWeek2;

public class Libro {
    private String codiceISBN;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;
    private String autore;
    private String genere;

    public Libro(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
        this.autore = autore;
        this.genere = genere;
    }
    
    public String toString() {
        return "Libro [codiceISBN = " + codiceISBN + ", titolo = " + titolo + ", annoPubblicazione = " + annoPubblicazione + ", numeroPagine = " + numeroPagine + ", autore = " + autore + ", genere = " + genere + "]";
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
    
    public String getAutore() {
        return autore;
    }
    
    public String getGenere() {
        return genere;
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
    
    public void setAutore(String autore) {
        this.autore = autore;
    }
    
    public void setGenere(String genere) {
        this.genere = genere;
    }

}
