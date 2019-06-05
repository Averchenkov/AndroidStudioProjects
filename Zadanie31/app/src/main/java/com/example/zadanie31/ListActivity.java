package com.example.zadanie31;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AppDatabase appDatabase;
    StudentDao dao;
    StudentsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        appDatabase = Database.getDatabase(getApplicationContext());
        dao = appDatabase.studentDao();
        adapter = new StudentsAdapter(Database.studentList);
        recyclerView.setAdapter(adapter);

    }
}
