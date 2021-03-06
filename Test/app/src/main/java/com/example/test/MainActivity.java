package com.example.test;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.test.FixTableAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public String[] title = {"title1","title2","title3","title4","title5","title6","title7",
            "title8","title9"};

    public List<DataBean> data = new ArrayList<>();

    public String[][] dataCopy = {
            {"dataadd1","dataadd2","dataadd3","dataadd4","dataadd5","dataadd6","dataadd7",
                    "dataadd8","dataadd9"}};

    int currentPage = 1;
    int totalPage = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 80; i++) {
            data.add(new DataBean("id__","data1","data2","data3","data4","data5","data6","data7",
                    "data8"));
        }

        final FixTableLayout fixTableLayout = (FixTableLayout) findViewById(R.id.fixTableLayout);

        // 一定要设置Adapter 否则看不到TableLayout
        final FixTableAdapter fixTableAdapter = new FixTableAdapter(title,data);
        fixTableLayout.setAdapter(fixTableAdapter);

        //LoadMoreData如果要设置 请在setAdapter之后
        fixTableLayout.enableLoadMoreData();

        fixTableLayout.setLoadMoreListener(new ILoadMoreListener() {
            @Override
            public void loadMoreData(final Message message) {
                Log.i("feng"," 加载更多 Data --- ");
                // 请自己开启线程加载数据，并通过message发送给fixTableLayout
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (currentPage <= totalPage) {
                            for (int i = 0; i < 50; i++) {
                                data.add(new DataBean("update_id","update_data","data2","data3","data4","data5",
                                        "data6","data7","data8"));
                            }
                            currentPage++;
                            message.arg1 = 50; // 更新了50条数据
                        } else {
                            message.arg1 = 0;
                        }
                        message.sendToTarget();
                    }
                }).start();
            }
        });
    }
}