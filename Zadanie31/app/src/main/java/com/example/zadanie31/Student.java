package com.example.zadanie31;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "student")
public class Student {
    @PrimaryKey
    public int ID;
    public String name;
    public String surname;
    public String patronymic;
    public long timestamp;
}
