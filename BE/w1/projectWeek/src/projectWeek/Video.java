package projectWeek;

 class Video extends ElementoMultimediale implements Riproducibile, Regolabile {
    private int luminosita;
    private int durata;
    private int volume;

    public Video(String titolo, int luminosita, int durata, int volume) {
        super(titolo);
        this.luminosita = luminosita;
        this.durata = durata;
        this.volume = volume;
    }

    public int getLuminosita() {
        return luminosita;
    }

    public void aumentaLuminosita() {
        luminosita++;
    }

    public void diminuisciLuminosita() {
        luminosita--;
    }
    
    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }
    
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    	
    	public void play() {
        for (int i = 0; i < durata; i++) {
            String puntiEsclamativi = "";
            for (int j = 0; j < volume; j++) {
                puntiEsclamativi += "!";
            }
            String asterischi = "";
            for (int j = 0; j < luminosita; j++) {
                asterischi += "*";
            }
            System.out.println(getTitolo() + " " + puntiEsclamativi + " " + asterischi);
        }
    }


    public void esegui() {
        play();
    }
}
