package com.ale.minichatapp.handler;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SOService {

    @GET("/api/public/test")
    Call<String> test();

}
