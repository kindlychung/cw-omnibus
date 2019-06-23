package vu.co.kaiyin.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private final String tag = "MainActivity";

    private int milliseconds = 0;
    private boolean running = false;
    private TextView timeView;
    private final int msPerHr = 3600000;
    private final int msPerMin = 60000;
    private final int interval = 113;
    private Integer taskToken = 0;
    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeView = findViewById(R.id.time_view);
        timeView.setText("00:00:00000");
    }

    public void onClickStart(View view) {
        running = true;
        runTimer();
    }

    public void onClickStop(View view) {
        running = false;
    }

    public void onClickReset(View view) {
        running = false;
        milliseconds = 0;
        handler.removeCallbacks(timerTask);
        timeView.setText("00:00:00000");
    }

    private void runTimer() {
        handler.post(timerTask);
    }

    private Runnable timerTask = new Runnable() {
            @Override
            public void run() {
                Log.d(tag, String.format("Stopwatch cycle %d", taskToken));
                int h = milliseconds / msPerHr;
                int m = (milliseconds % msPerHr) / msPerMin;
                int ms = milliseconds % msPerMin;
                String time = String.format(Locale.getDefault(),
                        "%02d:%02d:%05d", h, m, ms);
                timeView.setText(time);
                if (running)
                    milliseconds += interval;
                handler.postDelayed(this, ++taskToken, interval);
            }
        };
}
