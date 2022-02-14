package com.example.movieapp.data.movie

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("Poster")
    val poster: String,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Year")
    var year: String,
    val imdbID: String
)
