package com.example.moviescatalog.list_screen.domain.models

sealed class LoadMoviesState{
    object LoadingState: LoadMoviesState()
    data class MoviesFailResponse(val errorMessage: String): LoadMoviesState()
    data class MoviesSuccessResponse(val data: ArrayList<MovieUiModel>?, val totalCount: Long): LoadMoviesState()
}
