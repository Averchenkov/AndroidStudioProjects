package com.example.zadanie2;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/";

    @GET("data/techs.ruleset.json")
    Call<ArrayList<Technology>> getTechnology();
}
