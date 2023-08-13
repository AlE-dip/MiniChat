package com.ale.minichatapp.handler;

import com.ale.minichatapp.mapper.UserView;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SOService {

    @GET("api/public/test")
    Call<String> login();

}
