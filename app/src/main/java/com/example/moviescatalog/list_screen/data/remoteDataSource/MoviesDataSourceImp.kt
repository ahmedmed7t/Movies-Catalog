package com.example.moviescatalog.list_screen.data.remoteDataSource

import com.example.moviescatalog.app.api.ApiService
import javax.inject.Inject

class MoviesDataSourceImp @Inject constructor(private val apiService: ApiService) :
    MoviesDataSource {

    override suspend fun loadPopularMovies(
        page: Int,
        sortedBy: String
    ) = apiService.getAllMovies(page = page, sortBy = sortedBy)

    override suspend fun loadTopRatedMovies(
        page: Int,
        sortedBy: String
    ) = apiService.getAllMovies(page = page, sortBy = sortedBy)

    override suspend fun loadRevenueMovies(
        page: Int,
        sortedBy: String
    ) = apiService.getAllMovies(page = page, sortBy = sortedBy)

}