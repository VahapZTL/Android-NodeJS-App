package com.example.caranbula.loginex.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by VahapZTL on 5.10.2016.
 */

public class GetRegisterRes {

    @SerializedName("__v")
    private Integer v;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("_id")
    private String id;

    @SerializedName("createDate")
    private String createDate;

    public Integer getV() {
        return v;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public String getCreateDate() {
        return createDate;
    }
}
