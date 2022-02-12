package com.example.movieapp

import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.example.movieapp.data.Movie
import com.example.movieapp.data.moviedetails.MovieDetails
import com.example.movieapp.remote.MovieInterface
import com.example.movieapp.ui.details.MovieDetailsRepository
import com.example.movieapp.ui.movie.MoviePaging
import com.example.movieapp.utils.Events
import com.example.movieapp.utils.Result
import com.example.movieapp.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieInterface: MovieInterface,
    private val repository: MovieDetailsRepository
) : ViewModel() {

    private val query = MutableLiveData<String>()

    val list:LiveData<PagingData<Movie>> = query.switchMap {
        Pager(
            config = PagingConfig(10),
            pagingSourceFactory = {MoviePaging(it,movieInterface)}
        ).liveData.cachedIn(viewModelScope)
    }

    fun setQuery(s: String) {
        query.postValue(s)
    }

    private val _movieDetails = MutableLiveData<Events<Result<MovieDetails>>>()
    val movieDetails: LiveData<Events<Result<MovieDetails>>> = _movieDetails

    fun getMovieDetails(imdbId: String) = viewModelScope.launch {
        with(_movieDetails) {
            postValue(Events(Result(Status.LOADING, null, null)))
            postValue(Events(repository.getMovieDetails(imdbId)))
        }

    }
}