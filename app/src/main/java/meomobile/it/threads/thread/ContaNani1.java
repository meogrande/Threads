package meomobile.it.threads.thread;

/**
 * Created by fabio on 18/01/2016.
 */
public class ContaNani1 extends Thread {
    @Override
    public void run() {
        setName("settenani");
        System.out.println(Thread.currentThread().getName());
        for (int i=0; i<7; i++) {
            System.out.println((i+1)+" ");
        }
    }
}
