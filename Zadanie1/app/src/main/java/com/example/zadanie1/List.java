package com.example.zadanie1;

import android.app.ListActivity;
import android.os.Bundle;

public class List extends ListActivity {

    public static final int COUNT = 1000000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new MyArrayAdapter(this, new String[COUNT]));
    }
}

