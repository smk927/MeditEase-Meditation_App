package com.example.meditate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;

public class HomePage extends AppCompatActivity  {

    MyDatabaseHelper mydb;
    Button stop;
    String[][] meditate;
    TextView one1, one2, two1, two2, three1, three2, four1, four2, five1, five2, six1, six2, seven1, seven2;

    ImageView med,bre,dbplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        med=(ImageView)findViewById(R.id.meditatePlay);
        med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        bre=(ImageView) findViewById(R.id.breathingPlay);
        bre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });
        dbplay=(ImageView)findViewById(R.id.dbplay);
        dbplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });
    }
    public void openActivity3(){
        Intent intent = new Intent(this, MeditationPage.class);
        startActivity(intent);
    }
    public void openActivity4(){
        Intent intent = new Intent(this, BreathingPage.class);
        startActivity(intent);
    }
    public void openActivity5(){
        Intent intent = new Intent(this, StatsPage.class);
        startActivity(intent);
    }
}
