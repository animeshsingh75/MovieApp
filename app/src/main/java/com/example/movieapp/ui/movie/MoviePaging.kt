package com.example.movieapp.ui.movie

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.movieapp.data.movie.Movie
import com.example.movieapp.utils.Constants

class MoviePaging(private val str: String, private val movieRepository: MovieRepository) :
    PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: 1

        return try {

            val data = movieRepository.getAllMovies(str, page, Constants.API_KEY)
            LoadResult.Page(
                data = data.body()?.search!!,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (data.body()?.search?.isEmpty()!!) null else page + 1
            )


        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }


    }
}