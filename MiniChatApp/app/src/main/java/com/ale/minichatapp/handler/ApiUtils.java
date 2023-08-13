package com.ale.minichatapp.handler;

public class ApiUtils {

    public static final String BASE_URL = "http://192.168.1.4:8080";

    public static SOService getSOService() {
        return RetrofitClient.getInstance(BASE_URL).create(SOService.class);
    }

    public static LoginService getLoginService() {
        return RetrofitClient.getInstance(BASE_URL).create(LoginService.class);
    }


}
