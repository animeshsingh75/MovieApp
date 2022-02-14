package com.example.movieapp.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.moviedetails.MovieDetails
import com.example.movieapp.utils.Events
import com.example.movieapp.utils.Result
import com.example.movieapp.utils.Status
import kotlinx.coroutines.launch

class MovieDetailsViewModel : ViewModel() {
    private val movieDetailsRepository = MovieDetailsRepository()

    private val _movieDetails = MutableLiveData<Events<Result<MovieDetails>>>()
    val movieDetails: LiveData<Events<Result<MovieDetails>>> = _movieDetails

    fun getMovieDetails(imdbId: String) = viewModelScope.launch {
        with(_movieDetails) {
            postValue(Events(Result(Status.LOADING, null, null)))
            postValue(Events(movieDetailsRepository.getMovieDetails(imdbId)))
        }

    }
}