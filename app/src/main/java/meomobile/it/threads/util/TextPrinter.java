package meomobile.it.threads.util;

import android.widget.TextView;

/**
 * Creato da fabio on 18/01/2016.
 */
public class TextPrinter {
    static String text = "";
    static TextView tv;

    public static void println(String newText) {
        text += newText + "\n";

        tv.post(new Runnable() {
            public void run() {
                tv.setText(text);
            }
        });
    }

    public static void setTextView(TextView newTv) {
        tv = newTv;
    }
}
