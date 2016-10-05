package com.example.caranbula.loginex.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by VahapZTL on 5.10.2016.
 */

public class RegisterData {

    @SerializedName("success")
    private Boolean success;

    @SerializedName("data")
    private GetRegisterRes data;

    public Boolean getSuccess() {
        return success;
    }

    public GetRegisterRes getData() {
        return data;
    }
}
