package com.example.zadanie2;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private OnItemClickListner listner;
    private Context context;
    private LayoutInflater inflater;

    public ListAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public interface OnItemClickListner{
        void onItemClick(View v, int position);
    }

    public void setOnItemClickListner(OnItemClickListner listner){
        this.listner = listner;
    }


    public String getName(int i){
        return List.get(i).getName();
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = inflater.inflate(R.layout.recycleview_item, viewGroup, false);
        return new ListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder viewHolder, int i) {
        viewHolder.bind(List.get(i), i);
    }

    @Override
    public int getItemCount() {
        return List.getSize();
    }

    class ListViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView image;

        public ListViewHolder(@NonNull View itemView/*, final OnItemClickListner listner*/) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.imagelogov);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listner != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listner.onItemClick(v, position);
                        }
                    }
                }
            });
        }

        void bind(Technology technology, int position){
            name.setText(technology.getName());
            Picasso.get()
                    .load(technology.getGraphic())
                    .error(R.drawable.m404)
                    .into(image);
            String color = ((position + 1) % 2 == 0) ? "#C0C0C0" : "#FFFFFF";
            itemView.setBackgroundColor(Color.parseColor(color));
        }
    }
}
