package com.example.caranbula.loginex;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by caranbula on 28/09/16.
 */

public interface MyApi {

    public static String base_url = "http://192.168.1.15:3000";

    @POST("/api/login")
    Call<GetLoginRes> sendLogin(@Body MainActivity.loginPost a);

    @POST("/api/register")
    Call<GetLoginRes> sendRegister(@Body IndexActivity.registerPost r);
}
