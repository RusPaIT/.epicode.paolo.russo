package projectWeek;

 class Audio extends ElementoMultimediale implements Riproducibile {
    private int volume;
    private int durata;


    public Audio(String titolo, int volume, int durata) {
        super(titolo);
        this.volume = volume;
        this.durata = durata;
    }

    public int getVolume() {
        return volume;
    }

    public void alzaVolume() {
        volume++;
    }

    public void abbassaVolume() {
        volume--;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }
    

    public void play() {
        for (int i = 0; i < durata; i++) {
            String puntiEsclamativi = "";
            for (int j = 0; j < volume; j++) {
                puntiEsclamativi += "!";
            }
            System.out.println(getTitolo() + " " + puntiEsclamativi);
        }
    }

    public void esegui() {
        play();
    }


}


