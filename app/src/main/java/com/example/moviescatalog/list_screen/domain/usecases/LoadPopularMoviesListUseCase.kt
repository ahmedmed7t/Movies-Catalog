package com.example.moviescatalog.list_screen.domain.usecases

import com.example.moviescatalog.list_screen.data.models.MovieModel
import com.example.moviescatalog.list_screen.domain.models.LoadMoviesState
import com.example.moviescatalog.list_screen.domain.repository.MoviesRepository
import com.example.moviescatalog.list_screen.domain.toMoviesUiModel
import javax.inject.Inject

class LoadPopularMoviesListUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    suspend fun loadMovies(page: Int): LoadMoviesState {
        moviesRepository.loadPopularMovies(page).let {
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

    fun mock(): ArrayList<MovieModel> {
        val result = arrayListOf<MovieModel>()
        result.add(
            MovieModel(
                adult = false,
                backdrop_path = "/8YFL5QQVPy3AgrEQxNYVSgiPEbe.jpg",
                genre_ids = listOf(
                    28,
                    12,
                    878
                ),
                id = 640146,
                original_language = "en",
                original_title = "Ant-Man and the Wasp: Quantumania",
                overview = "Super-Hero partners Scott Lang and Hope van Dyne, along with with Hope's parents Janet van Dyne and Hank Pym, and Scott's daughter Cassie Lang, find themselves exploring the Quantum Realm, interacting with strange new creatures and embarking on an adventure that will push them beyond the limits of what they thought possible.",
                popularity = 9272.643,
                poster_path = "/ngl2FKBlU4fhbdsrtdom9LVLBXw.jpg",
                release_date = "2023-02-15",
                title = "Ant-Man and the Wasp: Quantumania",
                video = false,
                vote_average = 6.5,
                vote_count = 1856
            )
        )

        result.add(
            MovieModel(
                adult = false,
                backdrop_path = "/8YFL5QQVPy3AgrEQxNYVSgiPEbe.jpg",
                genre_ids = listOf(
                    28,
                    12,
                    878
                ),
                id = 640143,
                original_language = "en",
                original_title = "Ant-Man and the Wasp: Quantumania",
                overview = "Super-Hero partners Scott Lang and Hope van Dyne, along with with Hope's parents Janet van Dyne and Hank Pym, and Scott's daughter Cassie Lang, find themselves exploring the Quantum Realm, interacting with strange new creatures and embarking on an adventure that will push them beyond the limits of what they thought possible.",
                popularity = 9272.643,
                poster_path = "/ngl2FKBlU4fhbdsrtdom9LVLBXw.jpg",
                release_date = "2023-02-15",
                title = "Ant-Man and the Wasp: Quantumania",
                video = false,
                vote_average = 6.5,
                vote_count = 1856
            )
        )

        result.add(
            MovieModel(
                adult = false,
                backdrop_path = "/8YFL5QQVPy3AgrEQxNYVSgiPEbe.jpg",
                genre_ids = listOf(
                    28,
                    12,
                    878
                ),
                id = 640144,
                original_language = "en",
                original_title = "Ant-Man and the Wasp: Quantumania",
                overview = "Super-Hero partners Scott Lang and Hope van Dyne, along with with Hope's parents Janet van Dyne and Hank Pym, and Scott's daughter Cassie Lang, find themselves exploring the Quantum Realm, interacting with strange new creatures and embarking on an adventure that will push them beyond the limits of what they thought possible.",
                popularity = 9272.643,
                poster_path = "/ngl2FKBlU4fhbdsrtdom9LVLBXw.jpg",
                release_date = "2023-02-15",
                title = "Ant-Man and the Wasp: Quantumania",
                video = false,
                vote_average = 6.5,
                vote_count = 1856
            ))

        result.add(
            MovieModel(
                adult = false,
                backdrop_path = "/8YFL5QQVPy3AgrEQxNYVSgiPEbe.jpg",
                genre_ids = listOf(
                    28,
                    12,
                    878
                ),
                id = 640145,
                original_language = "en",
                original_title = "Ant-Man and the Wasp: Quantumania",
                overview = "Super-Hero partners Scott Lang and Hope van Dyne, along with with Hope's parents Janet van Dyne and Hank Pym, and Scott's daughter Cassie Lang, find themselves exploring the Quantum Realm, interacting with strange new creatures and embarking on an adventure that will push them beyond the limits of what they thought possible.",
                popularity = 9272.643,
                poster_path = "/ngl2FKBlU4fhbdsrtdom9LVLBXw.jpg",
                release_date = "2023-02-15",
                title = "Ant-Man and the Wasp: Quantumania",
                video = false,
                vote_average = 6.5,
                vote_count = 1856
            )
        )
        return result
    }
}