package com.example.moviescatalog.list_screen.domain

import com.example.moviescatalog.list_screen.data.models.MovieModel
import com.example.moviescatalog.list_screen.domain.models.MovieUiModel

fun MovieModel.toMovieUiModel(): MovieUiModel {
    return MovieUiModel(
        id = this.id,
        backdropPath = this.backdrop_path ?: "",
        originalLanguage = this.original_language ?: "",
        originalTitle = this.original_title ?: "",
        overview = this.overview ?: "",
        posterPath = this.poster_path ?: "",
        releaseDate = this.release_date ?: "",
        title = this.title ?: "",
        voteAverage = this.vote_average ?: 0.0,
        voteCount = this.vote_count ?: 0
    )
}

fun ArrayList<MovieModel>.toMoviesUiModel(): ArrayList<MovieUiModel> {
    val result = arrayListOf<MovieUiModel>()
    for (item in this) {
        result.add(item.toMovieUiModel())
    }
    return result
}