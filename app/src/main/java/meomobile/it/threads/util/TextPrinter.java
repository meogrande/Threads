package meomobile.it.threads.util;

import android.widget.TextView;

import meomobile.it.threads.R;

/**
 * Created by fabio on 18/01/2016.
 */
public class TextPrinter {
    static String text = new String();
    static TextView tv;
    public static void println(String newText) {
        text += newText + "\n";
        tv.setText(text);
    }

    public static void setTextView(TextView newTv) {
        tv = newTv;
    }
}
