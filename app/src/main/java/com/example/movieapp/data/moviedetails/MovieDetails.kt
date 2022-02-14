package com.example.movieapp.data.moviedetails

import com.google.gson.annotations.SerializedName

data class MovieDetails(
    @SerializedName("Actors")
    val actors: String,
    @SerializedName("Director")
    val director: String,
    @SerializedName("Genre")
    val genre: String,
    @SerializedName("Poster")
    val poster: String,
    @SerializedName("Released")
    val released: String,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Writer")
    val writer: String,
    @SerializedName("Year")
    val year: String,
    val imdbRating: String,
)