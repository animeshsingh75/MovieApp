package com.example.movieapp.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.example.movieapp.data.movie.Movie

class MovieViewModel() : ViewModel() {

    private val query = MutableLiveData<String>()
    private val movieRepository = MovieRepository()
    val list: LiveData<PagingData<Movie>> = query.switchMap {
        Pager(
            config = PagingConfig(10),
            pagingSourceFactory = { MoviePaging(it, movieRepository) }
        ).liveData.cachedIn(viewModelScope)
    }

    fun setQuery(s: String) {
        query.postValue(s)
    }
}