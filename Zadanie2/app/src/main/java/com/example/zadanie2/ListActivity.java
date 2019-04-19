package com.example.zadanie2;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ListActivity extends AppCompatActivity {

    private RecyclerView list;
    private ListAdapter listAdapter;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setTitle("Technology");

        list = findViewById(R.id.recyclerView);
        viewPager = findViewById(R.id.viewPager);

        listAdapter = new ListAdapter(this);
        list.setAdapter(listAdapter);
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);



        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                setTitle(List.get(i).getName());
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
        listAdapter.setOnItemClickListner(new ListAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(View view, int position)
            {
                viewPager.setCurrentItem(position);
                list.setVisibility(View.GONE);
                viewPager.setVisibility(View.VISIBLE);
                setTitle(List.get(position).getName());
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if(!list.isShown())
        {
            list.setVisibility(View.VISIBLE);
            viewPager.setVisibility(View.GONE);
            setTitle("Technology");
        }
        else
        {
            finish();
        }
    }
}
