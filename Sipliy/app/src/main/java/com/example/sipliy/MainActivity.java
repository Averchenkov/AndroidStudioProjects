package com.example.sipliy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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
        String[] list = new String[10];
        list[0] = "Ваня";
        list[1] = "Никита";
        list[2] = "Леша";
        list[3] = "Илья";
        list[4] = "Денис";
        list[5] = "Максим";

        RecyclerView players = (RecyclerView)findViewById(R.id.Players);
        List<String> llist = new ArrayList(Arrays.asList(list));
        players.setAdapter(new AnimalsAdapter(this,
                android.R.layout.simple_list_item_1, llist));
    }
}
