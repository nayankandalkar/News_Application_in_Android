package com.example.ram8;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apiinterface {
    String BASE_URL=" https://newsapi.org/v2/";
    @GET("top-headlines")
    Call<mainNews> getnews(
            @Query("country")  String country,
            @Query("pageSize") int pageSize,
            @Query("apiKey")   String apiKey
    );

    @GET("top-headlines")
    Call<mainNews> getCategerynews(
            @Query("country")  String country,
            @Query("category")  String category,
            @Query("pageSize") int pageSize,
            @Query("apiKey")   String apiKey
    );
}
