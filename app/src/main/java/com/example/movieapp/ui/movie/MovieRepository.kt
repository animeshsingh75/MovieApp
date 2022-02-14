package com.example.movieapp.ui.movie

import com.example.movieapp.data.api.Client

class MovieRepository {
    suspend fun getAllMovies(query: String, page: Int, apiKey: String) =
        Client.api.getAllMovies(query, page, apiKey)
}