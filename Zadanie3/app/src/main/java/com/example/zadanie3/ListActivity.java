package com.example.zadanie3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentsAdapter studentsAdapter;
    private ArrayList<Student> students;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e)
        {

        }
        setContentView(R.layout.activity_list);

        findViewById();
        buildRecyclerView();
        Intent intent = getIntent();
        students = (ArrayList<Student>)intent.getSerializableExtra("students");
        studentsAdapter.setStudents(students);
        //Toast.makeText(this, String.valueOf(intent.getSerializableExtra("students")), Toast.LENGTH_LONG).show();
    }

    private void buildRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        studentsAdapter = new StudentsAdapter();
        recyclerView.setAdapter(studentsAdapter);
    }

    private void findViewById(){
        recyclerView = findViewById(R.id.recyclerView);
    }
}
