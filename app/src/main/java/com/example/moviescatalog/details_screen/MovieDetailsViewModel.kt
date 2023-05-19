package com.example.moviescatalog.details_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviescatalog.list_screen.domain.models.MovieUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor() : ViewModel() {
    var popularMoviesListState = MutableLiveData<MovieUiModel>()
}