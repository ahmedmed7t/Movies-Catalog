package com.example.moviescatalog.list_screen.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviescatalog.list_screen.domain.models.LoadMoviesState
import com.example.moviescatalog.list_screen.domain.models.MovieUiModel
import com.example.moviescatalog.list_screen.domain.usecases.LoadPopularMoviesListUseCase
import com.example.moviescatalog.list_screen.domain.usecases.LoadRevenueMoviesListUseCase
import com.example.moviescatalog.list_screen.domain.usecases.LoadTopRatedMoviesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val popularMoviesListUseCase: LoadPopularMoviesListUseCase,
    private val topRatedMoviesListUseCase: LoadTopRatedMoviesListUseCase,
    private val revenueMoviesListUseCase: LoadRevenueMoviesListUseCase
) : ViewModel() {

    private var popularPageCount = 0
    private var topRatedPageCount = 0
    private var revenuePageCount = 0

    private val _popularMoviesListState = MutableLiveData<LoadMoviesState>()
    val popularMoviesListState: LiveData<LoadMoviesState> get() = _popularMoviesListState

    private val _topRatedMoviesListState = MutableLiveData<LoadMoviesState>()
    val topRatedMoviesListState: LiveData<LoadMoviesState> get() = _topRatedMoviesListState

    private val _revenueMoviesListState = MutableLiveData<LoadMoviesState>()
    val revenueMoviesListState: LiveData<LoadMoviesState> get() = _revenueMoviesListState

    fun loadAllMovies() {
        loadPopularMovies()
        loadTopRatedMovies()
        loadRevenueMovies()
    }

    fun loadPopularMovies() {
        viewModelScope.launch {
            val oldList = getExistingMovieList(_popularMoviesListState)
            popularPageCount++

            _popularMoviesListState.value = LoadMoviesState.LoadingState
            val newState = popularMoviesListUseCase.loadMovies(popularPageCount)

            if (newState is LoadMoviesState.MoviesSuccessResponse) {
                newState.data?.let { oldList.addAll(it) }
                _popularMoviesListState.value =
                    LoadMoviesState.MoviesSuccessResponse(oldList, newState.totalCount)
            } else {
                _popularMoviesListState.value = newState
            }
        }
    }

    fun loadTopRatedMovies() {
        viewModelScope.launch {
            val oldList = getExistingMovieList(_topRatedMoviesListState)
            topRatedPageCount++

            _topRatedMoviesListState.value = LoadMoviesState.LoadingState
            val newState = topRatedMoviesListUseCase.loadMovies(topRatedPageCount)

            if (newState is LoadMoviesState.MoviesSuccessResponse) {
                newState.data?.let { oldList.addAll(it) }
                _topRatedMoviesListState.value =
                    LoadMoviesState.MoviesSuccessResponse(oldList, newState.totalCount)
            } else {
                _topRatedMoviesListState.value = newState
            }
        }
    }

    fun loadRevenueMovies() {
        viewModelScope.launch {
            val oldList = getExistingMovieList(_revenueMoviesListState)
            revenuePageCount++

            _revenueMoviesListState.value = LoadMoviesState.LoadingState
            val newState = revenueMoviesListUseCase.loadMovies(revenuePageCount)

            if (newState is LoadMoviesState.MoviesSuccessResponse) {
                newState.data?.let { oldList.addAll(it) }
                _revenueMoviesListState.value =
                    LoadMoviesState.MoviesSuccessResponse(oldList, newState.totalCount)
            } else {
                _revenueMoviesListState.value = newState
            }
        }
    }

    private fun getExistingMovieList(categoryState: MutableLiveData<LoadMoviesState>): ArrayList<MovieUiModel> {
        val oldList = arrayListOf<MovieUiModel>()
        val oldState = categoryState.value
        if (oldState is LoadMoviesState.MoviesSuccessResponse)
            oldState.data?.let { oldList.addAll(it) }

        return oldList
    }
}