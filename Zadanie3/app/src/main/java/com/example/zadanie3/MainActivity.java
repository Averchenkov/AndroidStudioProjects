package com.example.zadanie3;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    private Button update;
    private Button insert;
    private Button show;
    private ArrayList<Student> students;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e)
        {

        }
        setContentView(R.layout.activity_main);
        findViewById();
        students = new ArrayList<>();
        db = new Database(this);
        final SQLiteDatabase database = db.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        int clearCount = database.delete(Database.TABLE_STUDENTS, null, null);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String date = simpleDateFormat.format(new Date());

        for (int i = 0; i < 5; i++) {
            contentValues.put(Database.KEY_FIO, RandomNames.getRandFio());
            contentValues.put(Database.KEY_TIME, date);
            database.insert(Database.TABLE_STUDENTS, null, contentValues);
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database = db.getReadableDatabase();
                Cursor cursor = database.query(Database.TABLE_STUDENTS, null, null, null, null, null, null);

                students = new ArrayList<>();
                int fioIndex = cursor.getColumnIndex(Database.KEY_FIO);
                int timeIndex = cursor.getColumnIndex(Database.KEY_TIME);

                if (cursor.moveToFirst()){
                    do{
                        students.add(new Student(String.valueOf(students.size() + 1), cursor.getString(fioIndex), cursor.getString(timeIndex)));
                    } while (cursor.moveToNext());
                    cursor.close();
                    Intent intent = new Intent(MainActivity.this, ListActivity.class);
                    intent.putExtra("students", (ArrayList<Student>)students);
                    startActivity(intent);
                }
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database = db.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                String date = simpleDateFormat.format(new Date());
                contentValues.put(Database.KEY_FIO, RandomNames.getRandFio());
                contentValues.put(Database.KEY_TIME, date);
                long i = database.insert(Database.TABLE_STUDENTS, null, contentValues);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database = db.getWritableDatabase();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                String sDate = simpleDateFormat.format(new Date());
                ContentValues contentValues = new ContentValues();
                contentValues.put(Database.KEY_FIO, RandomNames.getIvan());
                contentValues.put(Database.KEY_TIME, sDate);

                Cursor cursor = database.query(Database.TABLE_STUDENTS, null, null, null, null, null, null);
                int id = 0;
                int idIndex = cursor.getColumnIndex(Database.KEY_ID);
                if (cursor.moveToFirst()) {
                    do {
                        if (id < cursor.getInt(idIndex))
                            id = cursor.getInt(idIndex);
                    } while (cursor.moveToNext());
                }
                cursor.close();

                database.update(Database.TABLE_STUDENTS,contentValues,Database.KEY_ID + " = " + String.valueOf(id), null);
            }
        });
    }

    private void findViewById(){
        update = findViewById(R.id.update);
        insert = findViewById(R.id.insert);
        show = findViewById(R.id.show);
    }
}
