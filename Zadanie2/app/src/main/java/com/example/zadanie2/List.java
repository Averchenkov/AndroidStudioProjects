package com.example.zadanie2;

import java.util.ArrayList;

public class List {
    private static ArrayList<Technology> technologies;

    public static void create(){
        technologies = new ArrayList<>();
    }

    public static void addAll(ArrayList<Technology> arrayList) {
        technologies.addAll(arrayList);
        technologies.remove(0);
    }

    public static Technology get(int index) {
        return technologies.get(index);
    }

    public static int getSize() {
        return technologies.size();
    }

    public static void clear(){
        technologies.clear();
    }

    public static void add(Technology technology){
        technologies.add(technology);
    }

    public static void remove(int i){
        technologies.remove(i);
    }
}
