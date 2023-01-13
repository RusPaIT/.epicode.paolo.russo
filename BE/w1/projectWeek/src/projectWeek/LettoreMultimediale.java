package projectWeek;

import java.util.Scanner;

class LettoreMultimediale {
    private ElementoMultimediale[] elementi;
    private int indice = 0;

    public LettoreMultimediale() {
        elementi = new ElementoMultimediale[5];
    }

    public void aggiungiElemento(ElementoMultimediale elemento) {
        if (indice < elementi.length) {
            elementi[indice++] = elemento;
        } else {
            System.out.println("Impossibile aggiungere elementi: spazio esaurito");
        }
    }

    public void eseguiElemento(int indice) {
        if (indice >= 0 && indice < elementi.length) {
            if (elementi[indice] instanceof Riproducibile) {
                ((Riproducibile) elementi[indice]).play();
            } else {
                elementi[indice].esegui();
            }
        } else {
            System.out.println("Indice non valido");
        }
    }
}