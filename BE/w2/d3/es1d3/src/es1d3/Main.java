package es1d3;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintThread("*"));
        Thread t2 = new Thread(new PrintThread("#"));
        t1.start();
        t2.start();
    }
}

class PrintThread implements Runnable {
    private String symbol;

    public PrintThread(String symbol) {
        this.symbol = symbol;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println((i+1) + symbol);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



