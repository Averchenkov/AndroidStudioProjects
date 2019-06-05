package com.example.zadanie31;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    boolean isReady = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button firstButton = findViewById(R.id.show);
        Button secondButton = findViewById(R.id.insert);
        Button thirdButton = findViewById(R.id.update);
        final AppDatabase appDatabase = Database.getDatabase(getApplicationContext());
        isReady = false;
        new Thread(new Runnable() {
            @Override
            public void run() {
                appDatabase.studentDao().deleteAll();
                for (int i = 0; i < 5; i++) {
                    appDatabase.studentDao().insert(Database.generateStudent(i));
                }
                Database.studentList = appDatabase.studentDao().getAll();
                isReady = true;
            }
        }).start();

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isReady){
                    Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                    startActivity(intent);
                }
            }
        });
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isReady){
                    isReady = false;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            appDatabase.studentDao().insert(Database.generateStudent(Database.studentList.size()));
                            Database.studentList = appDatabase.studentDao().getAll();
                            isReady = true;
                        }
                    }).start();
                }
            }
        });
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isReady){
                    isReady = false;
                    Log.i("UPDATE BUTTON", Integer.toString(Database.studentList.size() - 1));
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            appDatabase.studentDao().updateById(Database.studentList.size() - 1);
                            Database.studentList = appDatabase.studentDao().getAll();
                            isReady = true;
                        }
                    }).start();
                }
            }
        });


    }
}