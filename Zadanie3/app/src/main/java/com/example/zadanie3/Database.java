package com.example.zadanie3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "lab3DB";
    public static final String TABLE_STUDENTS = "students";

    public static final String KEY_ID = "id";
    public static final String KEY_FIO = "fio";
    public static final String KEY_TIME = "time";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_STUDENTS + " ("
                + KEY_ID + " integer primary key autoincrement,"
                + KEY_FIO + " text,"
                + KEY_TIME + " text" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_STUDENTS);
        onCreate(db);
    }
}
