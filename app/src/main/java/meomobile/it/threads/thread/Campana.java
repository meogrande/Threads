package meomobile.it.threads.thread;

import meomobile.it.threads.util.TextPrinter;

/**
 * Created by fabio on 18/01/2016.
 */
public class Campana implements Runnable {
    String suono;
    int volte;
    public Campana (String suono, int volte) {
        this.suono = suono;
        this.volte = volte;
    }
    @Override
    public void run() {
        for (int i=0; i<volte; i++) {
            System.out.println((i+1)+suono+" ");
            try {
                Thread.sleep(5);                 // Attendo qualcosa tra un rintocco e l'altro
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
