package com.example.caranbula.loginex;

import com.google.gson.annotations.SerializedName;

/**
 * Created by caranbula on 28/09/16.
 */

public class GetLoginRes {

    @SerializedName("success")
    private String status;

    @SerializedName("data")
    private String data;

    public String getStatus() {
        return status;
    }

    public String getData() {
        return data;
    }
}
