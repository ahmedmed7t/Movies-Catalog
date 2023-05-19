package com.example.moviescatalog.list_screen.domain.usecases

import com.example.moviescatalog.list_screen.domain.models.LoadMoviesState
import com.example.moviescatalog.list_screen.domain.repository.MoviesRepository
import com.example.moviescatalog.list_screen.domain.toMoviesUiModel
import javax.inject.Inject

class LoadPopularMoviesListUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    suspend fun loadMovies(page: Int): LoadMoviesState {
        moviesRepository.loadPopularMovies(page).let {
            return if (it.isSuccessful && it.body()?.results != null) {
                LoadMoviesState.MoviesSuccessResponse(it.body()?.results?.toMoviesUiModel())
            } else {
                LoadMoviesState.MoviesFailResponse(it.body()?.statusMessage ?: "")
            }
        }
    }
}