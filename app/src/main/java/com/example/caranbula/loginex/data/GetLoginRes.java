package com.example.caranbula.loginex.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by caranbula on 28/09/16.
 */

public class GetLoginRes {

    @SerializedName("success")
    private String status;

    @SerializedName("data")
    private String data;

    @SerializedName("userID")
    private String userID;

    public String getStatus() {

        return status;
    }

    public String getData() {

        return data;
    }

    public String getUserID() {
        return userID;
    }
}
