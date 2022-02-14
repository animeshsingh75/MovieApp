package com.example.movieapp.ui.details

import com.example.movieapp.data.api.Client
import com.example.movieapp.data.moviedetails.MovieDetails
import com.example.movieapp.utils.Constants
import com.example.movieapp.utils.Result
import com.example.movieapp.utils.Status

class MovieDetailsRepository() {

    suspend fun getMovieDetails(imdbId: String): Result<MovieDetails> {

        return try {

            val response = Client.api.getMovieDetails(imdbId, Constants.API_KEY)
            if (response.isSuccessful) {

                Result(Status.SUCCESS, response.body(), null)

            } else {
                Result(Status.ERROR, null, null)
            }


        } catch (e: Exception) {
            Result(Status.ERROR, null, null)
        }


    }


}