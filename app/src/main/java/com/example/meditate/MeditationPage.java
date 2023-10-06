package com.example.meditate;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MeditationPage extends AppCompatActivity {
    private static final long START_TIMER = 600000;

    TextView count_text;
    Button start,reset;
    MyDatabaseHelper mydb = new MyDatabaseHelper(MeditationPage.this);
    CountDownTimer count;
    boolean time_running;
    private long TIME_LEFT = START_TIMER;
    String[][] meditate;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meditation_page);

        count_text = (TextView) findViewById(R.id.timer);
        start =(Button) findViewById(R.id.start_btn);
        reset = (Button) findViewById(R.id.reset_btn);

        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.music);

        meditate= new String[7][2];

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String currentDate= sdf.format(date);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(time_running){
                    pauseTimer();
                }
                else
                {
                    startTimer();
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mydb.addmeditate(currentDate);
                meditate=mydb.readData();
                resetTimer();

            }
        });

        updateCountDownText();
    }

    private void startTimer(){
        count =new CountDownTimer(START_TIMER, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mediaPlayer.start();
                mediaPlayer.setLooping(true);
                TIME_LEFT = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                time_running=false;
                start.setText(" Start ");
                start.setVisibility(View.INVISIBLE);
                reset.setVisibility(View.VISIBLE);
            }
        }.start();

        time_running=true;
        start.setText(" Pause ");
        reset.setVisibility(View.INVISIBLE);
    }
    private void pauseTimer(){
        mediaPlayer.pause();
        count.cancel();
        time_running=false;
        start.setText(" Start ");
        reset.setVisibility(View.VISIBLE);
    }
    private void resetTimer(){
        TIME_LEFT = START_TIMER;
        updateCountDownText();
        reset.setVisibility(View.INVISIBLE);
    }

    private void updateCountDownText(){
        int minutes = (int) (TIME_LEFT / 1000) / 60;
        int seconds = (int) (TIME_LEFT / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d",minutes,seconds);
        count_text.setText(timeLeftFormatted);
    }

}
