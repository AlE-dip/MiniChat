package com.ale.minichatapp.handler;

import com.ale.minichatapp.mapper.AuthRequest;
import com.ale.minichatapp.mapper.UserView;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {
    @POST("/api/public/login")
    Call<UserView> login(@Body AuthRequest authRequest);
}
