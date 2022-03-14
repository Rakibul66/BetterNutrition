package com.better.nutritiontherapy.breathe;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import com.better.nutritiontherapy.R;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import com.startapp.sdk.adsbase.StartAppAd;

import java.util.Timer;
import java.util.TimerTask;

public class FiveSecondBreathActivity extends AppCompatActivity {

    private boolean left = false;
    CircularProgressBar circularProgressBar;
    double progress = 1;
    MediaPlayer inHealPlayer, exHealPlayer;
    AppCompatTextView tvHealState, tvSecond;
    double timerSpeed = 10, progressSpeed = 0.2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_second_breath);

        circularProgressBar = findViewById(R.id.circularProgressBar);
        tvHealState = findViewById(R.id.tvHealState);
        tvSecond = findViewById(R.id.tvSecond);
        inHealPlayer = MediaPlayer.create(this, R.raw.three_exheal);
        exHealPlayer = MediaPlayer.create(this, R.raw.three_exheal);

        start();
        inHealPlayer.start();
    }

    private Timer timer;
    private final TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            if (left) {
                progress = progress - progressSpeed;
            } else {
                progress = progress + progressSpeed;
            }
            if (!left && progress >= 100) {
                left = true;
                runOnUiThread(() -> {
                    tvHealState.setText("ExHeal");
                    exHealPlayer.start();
                });
            }
            if (left && progress <= 0) {
                left = false;
                runOnUiThread(() -> {
                    tvHealState.setText("InHeal");
                    inHealPlayer.start();
                });
            }
            checkProgress();
            runOnUiThread(() -> {
                if (!tvSecond.getText().toString().equalsIgnoreCase(sec)) {
                    tvSecond.setText(sec);
                }
            });
            circularProgressBar.setProgress((float) progress);
        }
    };

    String sec = "1";

    private String checkProgress() {
        if (progress >= 80)
            return sec = left ? "1" : "5";

        if (progress >= 60)
            return sec = left ? "2" : "4";

        if (progress >= 40)
            return sec = "3";

        if (progress >= 20)
            return sec = left ? "4" : "2";

       return sec = left ? "5" : "1";

    }

    public void start() {
        if (timer != null) {
            return;
        }
        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, (long) timerSpeed);
    }

    public void stop() {
        timer.cancel();
        timer = null;
    }

    @Override
    protected void onDestroy() {
        stop();
        if (inHealPlayer != null) {
            inHealPlayer.release();
        }
        if (exHealPlayer != null) {
            exHealPlayer.release();
        }
        super.onDestroy();
    }
    @Override
    public void onBackPressed() {
        StartAppAd.onBackPressed(this);
        super.onBackPressed();
    }
}