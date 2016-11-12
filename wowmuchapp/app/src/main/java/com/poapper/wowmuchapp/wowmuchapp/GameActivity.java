package com.poapper.wowmuchapp.wowmuchapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {

    //if a variable should be referenced from different threads, make it volatile.
    private volatile int timeLeft = 10 * 1000;
    private int initialTime = 10 * 1000; //ms
    private final int INTERVAL = 100;

    private TextView timerText;
    private ProgressBar timerBar;

    private Handler handler = new Handler();
    private Timer timer;

    Runnable updateTimerVIew = new Runnable() {
        @Override
        public void run() {
            timerText.setText(String.valueOf(timeLeft/1000));
            timerBar.setProgress(timeLeft);
        }
    };

    TimerTask updateTimer = new TimerTask() {
        @Override
        public void run() {
            //notice that this code is run in different thread.
            timeLeft -= INTERVAL;
            //You cannot manipulate View directly in this thread. So, post runnable to main thread.
            if (timeLeft > 0) {
                handler.post(updateTimerVIew);
            }
            else {
                timer.cancel(); //You cannot use this timer anymore after cancel();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        timerText = (TextView) findViewById(R.id.tv_timer_text);
        timerBar = (ProgressBar) findViewById(R.id.timer_bar);

        timerBar.setMax(initialTime);
        timerBar.setProgress(initialTime);

        //Do things in fixed rate.
        timer = new Timer();
        //this will generate another thread.
        timer.scheduleAtFixedRate(updateTimer, 0, INTERVAL);
    }
}
