package es2d3;


public class SommaThreadWorker implements Runnable {
    private int[] valori;
    private int[] sommaParziale;
    private int indiceThread;

    public SommaThreadWorker(int[] valori, int[] sommaParziale, int indiceThread) {
        this.valori = valori;
        this.sommaParziale = sommaParziale;
        this.indiceThread = indiceThread;
    }

    public void run() {
        int inizio = indiceThread * 1000;
        int fine = inizio + 1000;
        for (int i = inizio; i < fine; i++) {
            sommaParziale[indiceThread] += valori[i];
        }
        System.out.println("Somma parziale thread " + (indiceThread + 1) + ": " + sommaParziale[indiceThread]);
    }
}

