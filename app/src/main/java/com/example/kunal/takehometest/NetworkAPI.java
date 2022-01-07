package com.example.kunal.takehometest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkAPI {

    @GET("/profile/U13023932")
    Call<User> getUserProfile();

    @GET("/purchases/U13023932?page=1")
    Call<List<Purchases>> getAllPurchases();

}
