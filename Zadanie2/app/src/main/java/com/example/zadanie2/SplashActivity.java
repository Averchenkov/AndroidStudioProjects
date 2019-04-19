package com.example.zadanie2;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplashActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private Api api;
    private ArrayList<Technology> technologies;
    private MyAsyncTask myAsyncTask = (MyAsyncTask) new MyAsyncTask();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e)
        {

        }
        setContentView(R.layout.activity_splash);
        myAsyncTask.execute();
    }


    class MyAsyncTask extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Intent intent = new Intent(SplashActivity.this, ListActivity.class);
            startActivity(intent);
            finish();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            List.create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(Api.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            api = retrofit.create(Api.class);
            technologies = new ArrayList<>();
            Call<ArrayList<Technology>> call = api.getTechnology();
            try {
                Response<ArrayList<Technology>> response = call.execute();
                technologies = response.body();
                assert technologies != null;
                List.addAll(technologies);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
