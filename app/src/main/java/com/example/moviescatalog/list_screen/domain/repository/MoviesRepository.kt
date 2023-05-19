package com.example.moviescatalog.list_screen.domain.repository

import com.example.moviescatalog.app.models.BaseResponse
import com.example.moviescatalog.list_screen.data.models.MovieModel
import retrofit2.Response

interface MoviesRepository {
    suspend fun loadPopularMovies(
        page: Int,
    ): Response<BaseResponse<ArrayList<MovieModel>>>

    suspend fun loadTopRatedMovies(
        page: Int,
    ): Response<BaseResponse<ArrayList<MovieModel>>>

    suspend fun loadRevenueMovies(
        page: Int,
    ): Response<BaseResponse<ArrayList<MovieModel>>>
}