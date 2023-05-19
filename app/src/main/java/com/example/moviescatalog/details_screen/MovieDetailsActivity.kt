package com.example.moviescatalog.details_screen

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.moviescatalog.R
import com.example.moviescatalog.app.toOriginalImage
import com.example.moviescatalog.databinding.ActivityMovieDetailsBinding
import com.example.moviescatalog.list_screen.domain.models.MovieUiModel
import com.example.moviescatalog.list_screen.presentation.MoviesListActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailsBinding
    private val viewModel: MovieDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listenToViewModelValues()
        getExtras()
    }

    private fun getExtras(){
        viewModel.popularMoviesListState.value = intent.getSerializableExtra(MOVIE_UI_MODEL_KEY) as? MovieUiModel
    }

    private fun listenToViewModelValues(){
        viewModel.popularMoviesListState.observe(this){
            bindMovieModel(it)
        }
    }

    private fun bindMovieModel(movieUiModel: MovieUiModel){
        binding.apply {
            Glide.with(this@MovieDetailsActivity).load(movieUiModel.backdropPath.toOriginalImage()).error(R.drawable.failed_image).into(movieDetailsPosterImage)
            movieDetailsTitle.text = movieUiModel.title
            movieDetailsRating.text = movieUiModel.voteAverage.toString()
            movieDetailsReleaseDate.text = movieUiModel.releaseDate
            movieDetailsOverView.text = movieUiModel.overview
        }
    }

    companion object {
        const val MOVIE_UI_MODEL_KEY = "MOVIE_UI_MODEL_KEY"
        fun getMovieDetailsIntent(context: Context, movieUiModel: MovieUiModel): Intent {
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.putExtra(MOVIE_UI_MODEL_KEY, movieUiModel)
            return intent
        }
    }
}