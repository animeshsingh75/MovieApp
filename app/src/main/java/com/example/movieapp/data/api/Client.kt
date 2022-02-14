package com.example.movieapp.data.api

import com.example.movieapp.utils.Constants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {
    private val gson = GsonBuilder()
        .create()
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    val api: MovieInterface = retrofit.create(MovieInterface::class.java)
}