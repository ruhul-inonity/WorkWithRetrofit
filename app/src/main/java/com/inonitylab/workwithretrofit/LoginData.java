package com.inonitylab.workwithretrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ruhul on 10/5/17.
 */

public class LoginData {
    @SerializedName("token")
    String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
