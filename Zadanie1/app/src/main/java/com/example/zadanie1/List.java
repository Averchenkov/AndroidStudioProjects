package com.example.zadanie1;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class List extends ListActivity {

    private ListView list;
    public static final int COUNT = 1000000;
    String[] number = new String[COUNT];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.rowlayout);
        createList();
    }

    String IntToString(int value, String str) {

        if(value == 0){
            return (str + "");
        }
        if(value == 1){
            return (str + "один ");
        }
        else if(value == 2){
            return (str + "два ");
        }
        else if(value == 3){
            return (str + "три ");
        }
        else if(value == 4){
            return (str + "четыре ");
        }
        else if(value == 5){
            return (str + "пять ");
        }
        else if(value == 6){
            return (str + "шесть ");
        }
        else if(value == 7){
            return (str + "семь ");
        }
        else if(value == 8){
            return (str + "восемь ");
        }
        else if(value == 9){
            return (str + "девять ");
        }
        else if(value == 10){
            return (str + "десять ");
        }
        else if(value == 11){
            return (str + "одиннадцать ");
        }
        else if(value == 12){
            return (str + "двеннадцать ");
        }
        else if(value == 13){
            return (str + "тринадцать ");
        }
        else if(value == 14){
            return (str + "четырнадцать ");
        }
        else if(value == 15){
            return (str + "пятнадцать ");
        }
        else if(value == 16){
            return (str + "шестнадцать ");
        }
        else if(value == 17){
            return (str + "семнадцать ");
        }
        else if(value == 18){
            return (str + "восемнадцать ");
        }
        else if(value == 19){
            return (str + "девятнадцать ");
        }


        else if((value >= 20) && (value <= 29)){
            return (str + "двадцать " + IntToString(value % 10, str));
        }
        else if((value >= 30) && (value <= 39)){
            return (str + "тридцать " + IntToString(value % 10, str));
        }
        else if((value >= 40) && (value <= 49)){
            return (str + "сорок " + IntToString(value % 10, str));
        }
        else if((value >= 50) && (value <= 59)){
            return (str + "пятьдесят " + IntToString(value % 10, str));
        }
        else if((value >= 60) && (value <= 69)){
            return (str + "шестьдесят " + IntToString(value % 10, str));
        }
        else if((value >= 70) && (value <= 79)){
            return (str + "семьдесят " + IntToString(value % 10, str));
        }
        else if((value >= 80) && (value <= 89)){
            return (str + "восемьдесят " + IntToString(value % 10, str));
        }
        else if((value >= 90) && (value <= 99)){
            return (str + "девяносто " + IntToString(value % 10, str));
        }


        else if((value >= 100) && (value <= 199)){
            return (str + "сто " + IntToString(value % 100, str));
        }
        else if((value >= 200) && (value <= 299)){
            return (str + "двести " + IntToString(value % 100, str));
        }
        else if((value >= 300) && (value <= 399)){
            return (str + "триста " + IntToString(value % 100, str));
        }
        else if((value >= 400) && (value <= 499)){
            return (str + "четыреста " + IntToString(value % 100, str));
        }
        else if((value >= 500) && (value <= 599)){
            return (str + "пятьсот " + IntToString(value % 100, str));
        }
        else if((value >= 600) && (value <= 699)){
            return (str + "шестьсот " + IntToString(value % 100, str));
        }
        else if((value >= 700) && (value <= 799)){
            return (str + "семьсот " + IntToString(value % 100, str));
        }
        else if((value >= 800) && (value <= 899)){
            return (str + "восемьсот " + IntToString(value % 100, str));
        }
        else if((value >= 900) && (value <= 999)){
            return (str + "девятьсот " + IntToString(value % 100, str));
        }


        else if((value >= 1000) && (value <= 999999)){
            if(((value / 1000) % 10 == 1) && ((value / 1000) % 100 != 11)) {
                return (str + IntToString((value / 10000) * 10, str) + "одна тясяча " + IntToString(value % 1000, str));
            }
            else if(((value / 1000) % 10 == 2) && ((value / 1000) % 100 != 12)) {
                return (str + IntToString((value / 10000) * 10, str) + "две тясячи " + IntToString(value % 1000, str));
            }
            else if(((value / 1000) % 10 == 3) && ((value / 1000) % 100 != 13)) {
                return (str + IntToString((value / 10000) * 10, str) + "три тясячи " + IntToString(value % 1000, str));
            }
            else if(((value / 1000) % 10 == 4) && ((value / 1000) % 100 != 14)) {
                return (str + IntToString((value / 10000) * 10, str) + "четыере тясячи " + IntToString(value % 1000, str));
            }
            else
                return (str + IntToString(value / 1000, str) + "тясяч " + IntToString(value % 1000, str));
        }

        else if (value == 1000000){
            return "один мсллион";
        }


        else return "ERROR";


    }

    public void createList(){
        //list = (ListView)findViewById(R.id.List);
        for (int i = 1; i <= COUNT; i++) {
            number[i-1] = IntToString(i,"");
        }
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, number);
        setListAdapter(new MyArrayAdapter(this, number));

    }
}

