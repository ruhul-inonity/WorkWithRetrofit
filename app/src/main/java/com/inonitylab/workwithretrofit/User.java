package com.inonitylab.workwithretrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ruhul on 10/5/17.
 */

public class User {
    @SerializedName("mobile")
    String mobile;
    @SerializedName("password")
    String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
