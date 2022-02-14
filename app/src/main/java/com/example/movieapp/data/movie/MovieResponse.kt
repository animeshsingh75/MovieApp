package com.example.movieapp.data.movie

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val response: String,
    @SerializedName("Search")
    val search: List<Movie>,
    val totalResults: String
)