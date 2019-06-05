package com.example.zadanie3;

import java.io.Serializable;

public class Student implements Serializable {
    private String id;
    private String fio;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Student(String id, String fio, String time) {
        this.id = id;
        this.fio = fio;
        this.time = time;
    }

    private String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
