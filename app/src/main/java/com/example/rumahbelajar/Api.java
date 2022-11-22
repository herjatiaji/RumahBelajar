package com.example.rumahbelajar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("beers")
    Call<Kelas> getRandomBeer();

    @GET("beers")
    Call<List<Kelas>> getBeers(@Query("size") int number);

    @GET("/3/movie/{category}")
    Call<Kelas> getMovie(
            @Path("category") String category,
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("page") int page
    );
}
