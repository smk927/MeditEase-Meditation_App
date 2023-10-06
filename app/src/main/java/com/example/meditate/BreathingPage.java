package com.example.meditate;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Locale;

public class BreathingPage extends AppCompatActivity {
    Button b;
    TextView t;
    LottieAnimationView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breathing_page);
        b=findViewById(R.id.breatheButton);
        t=findViewById(R.id.breatheText);
        l=findViewById(R.id.breatheView);
        t.setVisibility(View.INVISIBLE);
        l.setVisibility(View.INVISIBLE);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                t.setVisibility(View.VISIBLE);
                l.setVisibility(View.VISIBLE);
                b.setVisibility(View.INVISIBLE);
            }
        });
    }
}
