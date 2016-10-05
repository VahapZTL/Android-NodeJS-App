package com.example.caranbula.loginex.data;

import com.example.caranbula.loginex.RegisterActivity;
import com.example.caranbula.loginex.MainActivity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by caranbula on 28/09/16.
 */

public interface MyApi {

    public static String base_url = "https://denemenode.herokuapp.com";

    @POST("/api/login")
    Call<GetLoginRes> sendLogin(@Body MainActivity.loginPost a);

    @POST("/api/register")
    Call<RegisterData> sendRegister(@Body RegisterActivity.registerPost r);
}
