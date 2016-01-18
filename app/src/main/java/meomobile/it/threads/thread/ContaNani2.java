package meomobile.it.threads.thread;

/**
 * Created by fabio on 18/01/2016.
 */
public class ContaNani2 extends Thread{
    public ContaNani2(String nome) {
        super();
        setName(nome);
    }
    public void run() {
        for (int i=0; i<7; i++) {
            System.out.println((i+1) + " " + getName());
            // Faccio attendere 100 ms altrimenti è troppo veloce e non si vede che i thread si mescolano
            try {
                Thread.sleep(50);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
