package com.example.moviescatalog.list_screen.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.moviescatalog.app.showErrorToast
import com.example.moviescatalog.databinding.ActivityMoviesListBinding
import com.example.moviescatalog.list_screen.domain.models.LoadMoviesState
import com.example.moviescatalog.list_screen.domain.models.MovieUiModel
import com.example.moviescatalog.list_screen.presentation.adapter.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoviesListBinding
    private val viewModel: MoviesListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        listenToViewModelValues()
        viewModel.loadAllMovies()
    }

    private fun initViews() {
        binding.apply {
            popularMoviesList.apply {
                adapter = MovieAdapter { popularMovie ->
                    navigateToDetailsScreen(popularMovie)
                }
                addPagination {
                    if (viewModel.popularMoviesListState.value != LoadMoviesState.LoadingState)
                        viewModel.loadPopularMovies()
                }
            }

            topRatedMoviesList.apply {
                adapter = MovieAdapter { topRatedMovie ->
                    navigateToDetailsScreen(topRatedMovie)
                }
                addPagination {
                    if (viewModel.topRatedMoviesListState.value != LoadMoviesState.LoadingState)
                        viewModel.loadTopRatedMovies()
                }
            }

            revenueMoviesList.apply {
                adapter = MovieAdapter { revenueMovie ->
                    navigateToDetailsScreen(revenueMovie)
                }
                addPagination {
                    if (viewModel.revenueMoviesListState.value != LoadMoviesState.LoadingState)
                        viewModel.loadRevenueMovies()
                }
            }
        }
    }

    private fun listenToViewModelValues() {
        viewModel.popularMoviesListState.observe(this) { popularMoviesState ->
            when (popularMoviesState) {
                LoadMoviesState.LoadingState -> {}
                is LoadMoviesState.MoviesFailResponse -> showErrorToast(popularMoviesState.errorMessage)
                is LoadMoviesState.MoviesSuccessResponse -> (binding.popularMoviesList.adapter as? MovieAdapter)?.submitList(
                    popularMoviesState.data
                )
            }
        }

        viewModel.topRatedMoviesListState.observe(this) { topRatedMoviesState ->
            when (topRatedMoviesState) {
                LoadMoviesState.LoadingState -> {}
                is LoadMoviesState.MoviesFailResponse -> showErrorToast(topRatedMoviesState.errorMessage)
                is LoadMoviesState.MoviesSuccessResponse -> (binding.topRatedMoviesList.adapter as? MovieAdapter)?.submitList(
                    topRatedMoviesState.data
                )
            }
        }

        viewModel.revenueMoviesListState.observe(this) { revenueMoviesState ->
            when (revenueMoviesState) {
                LoadMoviesState.LoadingState -> {}
                is LoadMoviesState.MoviesFailResponse -> showErrorToast(revenueMoviesState.errorMessage)
                is LoadMoviesState.MoviesSuccessResponse -> (binding.revenueMoviesList.adapter as? MovieAdapter)?.submitList(
                    revenueMoviesState.data
                )
            }
        }
    }

    private fun navigateToDetailsScreen(movieUiModel: MovieUiModel) {

    }
}