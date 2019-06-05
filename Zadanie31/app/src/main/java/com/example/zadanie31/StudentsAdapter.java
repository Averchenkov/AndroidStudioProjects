package com.example.zadanie31;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentHolder>{
    ArrayList<Student> students;

    public StudentsAdapter(List<Student> students) {
        this.students = new ArrayList<>();
        this.students.addAll(students);
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.list_item, viewGroup, false);
        StudentHolder holder = new StudentHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder studentHolder, int i) {
        studentHolder.idTextView.setText(Integer.toString(students.get(i).ID));
        String nline = "";
        nline += students.get(i).surname + " " + students.get(i).name + " " + students.get(i).patronymic;
        studentHolder.fioTextView.setText(nline);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        studentHolder.dateTextView.setText(date);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentHolder extends RecyclerView.ViewHolder{
        TextView idTextView;
        TextView fioTextView;
        TextView dateTextView;

        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            idTextView = itemView.findViewById(R.id.id);
            fioTextView = itemView.findViewById(R.id.fio);
            dateTextView = itemView.findViewById(R.id.time);

        }
    }
}
