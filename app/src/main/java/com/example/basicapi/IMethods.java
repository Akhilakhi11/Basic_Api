package com.example.basicapi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IMethods {

    @GET("api/users?page=2")
    Call<Response1> getAllData();
    @GET
}
