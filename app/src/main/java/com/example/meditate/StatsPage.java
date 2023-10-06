package com.example.meditate;
import java.text.SimpleDateFormat;
import java.util.Date;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.meditate.MyDatabaseHelper;

public class StatsPage extends AppCompatActivity {
    MyDatabaseHelper mydb;
    String[][] meditate;
    TextView one1, one2, two1, two2, three1, three2, four1, four2, five1, five2, six1, six2, seven1, seven2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_page);
        mydb= new MyDatabaseHelper(StatsPage.this);
        meditate= new String[7][2];
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String currentDate= sdf.format(date);

        one1=findViewById(R.id.one1);
        one2=findViewById(R.id.one2);

        two1=findViewById(R.id.two1);
        two2=findViewById(R.id.two2);

        three1=findViewById(R.id.three1);
        three2=findViewById(R.id.three2);

        four1=findViewById(R.id.four1);
        four2=findViewById(R.id.four2);

        five1=findViewById(R.id.five1);
        five2=findViewById(R.id.five2);

        six1=findViewById(R.id.six1);
        six2=findViewById(R.id.six2);

        seven1=findViewById(R.id.seven1);
        seven2=findViewById(R.id.seven2);
        meditate=mydb.readData();
        displayData();
    }
    void displayData(){
        one1.setText(meditate[0][0]);
        one2.setText(meditate[0][1]);

        two1.setText(meditate[1][0]);
        two2.setText(meditate[1][1]);

        three1.setText(meditate[2][0]);
        three2.setText(meditate[2][1]);

        four1.setText(meditate[3][0]);
        four2.setText(meditate[3][1]);

        five1.setText(meditate[4][0]);
        five2.setText(meditate[4][1]);

        six1.setText(meditate[5][0]);
        six2.setText(meditate[5][1]);

        seven1.setText(meditate[6][0]);
        seven2.setText(meditate[6][1]);
    }
}