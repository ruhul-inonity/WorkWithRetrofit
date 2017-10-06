package com.inonitylab.workwithretrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by ruhul on 8/11/17.
 */

public interface ApiService {
    @FormUrlEncoded
    @POST("login")
    Call<Student> insertData(@Body Student student);




    @POST("login")
    Call<LoginResponse> createUser(@Body User user);
}
