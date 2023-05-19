package com.example.moviescatalog.list_screen.domain.usecases

import com.example.moviescatalog.list_screen.domain.models.LoadMoviesState
import com.example.moviescatalog.list_screen.domain.repository.MoviesRepository
import com.example.moviescatalog.list_screen.domain.toMoviesUiModel
import javax.inject.Inject

class LoadRevenueMoviesListUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    suspend fun loadMovies(page: Int): LoadMoviesState {
        moviesRepository.loadRevenueMovies(page).let {
            return if (it.isSuccessful && it.body()?.results != null) {
                LoadMoviesState.MoviesSuccessResponse(
                    it.body()?.results?.toMoviesUiModel(),
                    it.body()?.totalResults ?: 0
                )
            } else {
                LoadMoviesState.MoviesFailResponse(it.body()?.statusMessage ?: "")
            }
        }
    }
}