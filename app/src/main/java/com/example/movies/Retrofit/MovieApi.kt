package com.example.movies.Retrofit

import com.example.movies.ModelClasses.AutoComplete
import com.example.movies.ModelClasses.D
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface MovieApi {
    @Headers(
        "Accept: application/json",
        "X-RapidAPI-Key: 322196f639mshb8ac08b332ac693p1c3d66jsn4ef5ad0870a6",
        "X-RapidAPI-Host: online-movie-database.p.rapidapi.com"
    )
    @GET("auto-complete?q=Pushpa")
    fun getMovies(): Call<AutoComplete?>?




}