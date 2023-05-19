package com.example.moviescatalog.list_screen.domain.models

data class MovieUiModel(
    val backdropPath: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
    val voteCount: Int
)