package com.example.zadanie2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewPagerAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;
    private Context context;

    public ViewPagerAdapter(Context context)
    {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return List.getSize();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.viewpager_item, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.imagelogov);
        TextView textView = (TextView) view.findViewById(R.id.namev);

        textView.setText(List.get(position).getHelptext());

        Picasso.get()
                .load(List.get(position).getGraphic())
                .error(R.drawable.m404)
                .into(imageView);
        container.addView(view);
        return view;
    }
}
