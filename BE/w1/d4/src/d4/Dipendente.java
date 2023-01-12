package d4;

public class Dipendente {
	
	
	
    public static final double stipendioBase = 1000;
    private static int matricola;
    private double stipendio;
    private double importoOrarioStraordinario;
    private String livello;
    private String dipartimento;
    public static final String[] livelli = {"OPERAIO", "IMPIEGATO", "QUADRO", "DIRIGENTE"};
    public static final String[] dipartimenti = {"PRODUZIONE", "AMMINISTRAZIONE", "VENDITE"};

    // Costruttore che accetta solo la matricola, Dipartimento
    public Dipendente(int matricola, String dipartimento) {
        this.matricola = matricola;
        this.dipartimento = dipartimento;
        this.stipendio = stipendioBase;
        this.importoOrarioStraordinario = 30;
        this.livello = "OPERAIO";
    }

    // Costruttore che accetta tutti i parametri
    public Dipendente(int matricola, String dipartimento, double stipendio, double importoOrarioStraordinario, String livello) {
        this.matricola = matricola;
        this.dipartimento = dipartimento;
        this.stipendio = stipendio;
        this.importoOrarioStraordinario = importoOrarioStraordinario;
        this.livello = livello;
    }

    public double getStipendio() {
        return stipendio;
    }

    public double getImportoOrarioStraordinario() {
        return importoOrarioStraordinario;
    }

    public String getLivello() {
        return livello;
    }

    public String getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(String dipartimento) {
        for (String dip : dipartimenti) {
            if (dip.equals(dipartimento)) {
                this.dipartimento = dipartimento;
                return;
            }
        }
        throw new IllegalArgumentException("Dipartimento non valido");
    }

    public void setImportoOrarioStraordinario(double importo) {
        this.importoOrarioStraordinario = importo;
    }

    public  void stampaDatiDipendente() {
        System.out.println("Matricola: " + matricola);
        System.out.println("Stipendio: " + stipendio);
        System.out.println("Importo orario straordinario: " + importoOrarioStraordinario);
        System.out.println("Livello: " + livello);
        System.out.println("Dipartimento: " + dipartimento);
    }

    public String promuovi() {
        switch (livello) {
            case "OPERAIO":
                livello = "IMPIEGATO";
                stipendio = stipendioBase * 1.2;
                break;
            case "IMPIEGATO":
                livello = "QUADRO";
                stipendio = stipendioBase * 1.5;
                break;
            case "QUADRO":
                livello = "DIRIGENTE";
                stipendio = stipendioBase * 2;
                break;
            case "DIRIGENTE":
                System.out.println("Errore: il dipendente è già un dirigente.");
                break;
        }
        return livello;
    }
    

        public static double calcolaPaga(Dipendente dipendente) {
            return dipendente.getStipendio();
        }

        public static double calcolaPaga(Dipendente dipendente, int oreStraordinario) {
            return dipendente.getStipendio() + (oreStraordinario * dipendente.importoOrarioStraordinario);
        }
    
    
}



