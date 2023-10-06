package com.example.meditate;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class breathing1 extends AppCompatActivity {
    Button b;
    TextView t;
    LottieAnimationView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        b = findViewById(R.id.breathingButton);
//        t = findViewById(R.id.textView);
//        l = findViewById(R.id.breathingAnimation);
//        t.setVisibility(View.INVISIBLE);
//        l.setVisibility(View.INVISIBLE);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setVisibility(View.VISIBLE);
                l.setVisibility(View.VISIBLE);
            }
        });
    }
}
