package com.example.chess;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static android.content.Context.MODE_PRIVATE;

import static com.example.chess.PieceEnum.KING;

public class ColumnsAdapter extends RecyclerView.Adapter<ColumnsAdapter.ColumnViewHolder> {


    private final static String FILE_NAME = "content.txt";



    @NonNull
    @Override
    public ColumnViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.columns_item, viewGroup, false);
        return new ColumnViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ColumnViewHolder viewHolder, int i) {
        viewHolder.bind(Data.getLine(i));
    }

    @Override
    public int getItemCount() {
        return Data.getSize();
    }

    class ColumnViewHolder extends RecyclerView.ViewHolder{

        private RecyclerView lines;
        private LinesAdapter linesAdapter;

        public ColumnViewHolder(@NonNull final View itemView) {
            super(itemView);

            lines = itemView.findViewById(R.id.lines);
            bildRecyclerView();
            linesAdapter.setOnItemClickListner(new LinesAdapter.OnItemClickListner() {
                @Override
                public void onItemClick(int position) {
                    int column = getAdapterPosition();
                    int line = position;
                    Data.setGreenWay(column, line);
                    notifyDataSetChanged();
                }
            });
        }

        public void bildRecyclerView() {
            LinearLayoutManager layoutManagerPlayers = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.VERTICAL, false);
            lines.setLayoutManager(layoutManagerPlayers);
            linesAdapter = new LinesAdapter();
            lines.setAdapter(linesAdapter);
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(lines.getContext(),
                    layoutManagerPlayers.getOrientation());
            lines.addItemDecoration(dividerItemDecoration);
        }

        void bind(ArrayList<Cell> list){
            linesAdapter.addAll(list);
        }

        void write(Context ctx){
            FileOutputStream fos = null;
            try {
                fos = ctx.openFileOutput(FILE_NAME, ctx.MODE_APPEND);
                String text = "dsfsd";
                fos.write(text.getBytes());
                Toast.makeText(ctx, "Файл сохранен", Toast.LENGTH_SHORT).show();
            }
            catch(IOException ex) {

                Toast.makeText(ctx, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
            finally{
                try{
                    if(fos!=null)
                        fos.close();
                }
                catch(IOException ex){

                    Toast.makeText(ctx, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
//            for (int i = 0; i < 8; i++) {
//                for (int j = 0; j < 8; j++) {
//                    if (arrayList.get(i).get(j).isPoint()){
//                        System.out.print("1 ");
//                    }
//                    else {
//                        System.out.print("0 ");
//                    }
//                }
//                System.out.println();
//            }
        }
    }
}
