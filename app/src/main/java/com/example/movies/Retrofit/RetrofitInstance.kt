package com.example.movies.Retrofit

import android.app.TaskStackBuilder.create
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
//    lateinit var mealApi :MealApi
//    init {
//
//    }

    val api by lazy {
        Retrofit.Builder()
            .baseUrl("https://online-movie-database.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }
}