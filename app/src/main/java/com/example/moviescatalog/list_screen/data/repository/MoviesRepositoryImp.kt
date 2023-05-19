package com.example.moviescatalog.list_screen.data.repository

import com.example.moviescatalog.list_screen.data.remoteDataSource.MoviesDataSource
import com.example.moviescatalog.list_screen.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImp @Inject constructor(private val moviesDataSource: MoviesDataSource) :
    MoviesRepository {

    override suspend fun loadPopularMovies(page: Int) =
        moviesDataSource.loadPopularMovies(page = page)

    override suspend fun loadTopRatedMovies(page: Int) =
        moviesDataSource.loadTopRatedMovies(page = page)

    override suspend fun loadRevenueMovies(page: Int) =
        moviesDataSource.loadRevenueMovies(page = page)

}