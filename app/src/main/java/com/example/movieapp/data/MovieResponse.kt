package com.example.movieapp.data

data class MovieResponse(
    val response: String,
    val Search: List<Movie>,
    val totalResults: String
)