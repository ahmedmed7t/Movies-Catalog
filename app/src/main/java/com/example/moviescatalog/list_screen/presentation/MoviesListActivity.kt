package com.example.moviescatalog.list_screen.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviescatalog.databinding.ActivityMoviesListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoviesListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}