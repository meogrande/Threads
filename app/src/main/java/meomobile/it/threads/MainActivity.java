package meomobile.it.threads;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import meomobile.it.threads.thread.Campana;
import meomobile.it.threads.thread.ContaNani1;
import meomobile.it.threads.thread.ContaNani2;
import meomobile.it.threads.thread.Racchetta;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Avvio il thread settenani
                ContaNani1 cn = new ContaNani1();
                cn.start();
                System.out.println(Thread.currentThread().getName());

                // Avvio il thread settenani 2
                Thread thr1 = new ContaNani2("fabio");
                Thread thr2 = new ContaNani2("michele");
                thr1.start();
                thr2.start();

                try {
                    Thread.sleep(2000);                 // Attendo due secondi tra un programmino e l'altro
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }

                // Avvio il programmino delle campane
                Runnable cam1 = new Campana("din", 5);
                Thread thr3 = new Thread(cam1);
                thr3.start();
                Thread thr4 = new Thread(new Campana("don", 5));
                thr4.start();

                // Comincia il ping pong
                try {
                    Thread.sleep(2000);                 // Attendo due secondi tra un programmino e l'altro
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                // Ping pong
                System.out.println("Comincia il ping pong");
                Thread thr5 = new Thread(new Racchetta("ping"));
                thr5.start();
                // secondo giocatore
                Thread thr6 = new Thread(new Racchetta("pong"));
                thr6.start();

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
