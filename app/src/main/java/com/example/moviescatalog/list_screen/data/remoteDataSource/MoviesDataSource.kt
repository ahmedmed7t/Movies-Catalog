package com.example.moviescatalog.list_screen.data.remoteDataSource

import com.example.moviescatalog.app.models.BaseResponse
import com.example.moviescatalog.list_screen.data.models.MovieModel
import retrofit2.Response

interface MoviesDataSource {
    suspend fun loadPopularMovies(
        page: Int,
        sortedBy: String = "popularity.desc"
    ): Response<BaseResponse<ArrayList<MovieModel>>>

    suspend fun loadTopRatedMovies(
        page: Int,
        sortedBy: String = "vote_count.desc"
    ): Response<BaseResponse<ArrayList<MovieModel>>>

    suspend fun loadRevenueMovies(
        page: Int,
        sortedBy: String = "revenue.desc"
    ): Response<BaseResponse<ArrayList<MovieModel>>>
}