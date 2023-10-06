package com.example.meditate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Statistics.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "my_history";
    private static final String COLUMN_DATE = "date";

    public MyDatabaseHelper(Context context) {
        super(context , DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+TABLE_NAME+
                " ("+COLUMN_DATE+" VARCHAR(10) PRIMARY KEY );";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
    void addmeditate(String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_DATE, date);
        try {
            db.insert(TABLE_NAME, null, cv);
        }
        catch(Exception e){

        }
    }
    Cursor readData(String cal){
        SQLiteDatabase db = this.getWritableDatabase();
        if(db==null)
            return null;
        String query = "SELECT * FROM "+TABLE_NAME+" WHERE "+COLUMN_DATE+" = '"+ cal +"';";
        return db.rawQuery(query, null);
    }
    String[][] readData(){
        Calendar cal= Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String currentDate= sdf.format(date);
        try {
            cal.setTime(sdf.parse(currentDate));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        cal.add(Calendar.DAY_OF_MONTH, -7);

        String[][] meditate= new String[7][2];
        String after;
        for(int i=0;i<7;i++) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
            after= sdf.format(cal.getTime());
            meditate[i][0]=after;
            if(readData(after).getCount()!=0)
                meditate[i][1]="Yes";
            else
                meditate[i][1]="No";
        }
        return meditate;
    }
}