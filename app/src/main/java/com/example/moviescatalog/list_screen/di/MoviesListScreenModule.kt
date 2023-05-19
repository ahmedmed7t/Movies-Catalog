package com.example.moviescatalog.list_screen.di

import com.example.moviescatalog.list_screen.data.remoteDataSource.MoviesDataSource
import com.example.moviescatalog.list_screen.data.remoteDataSource.MoviesDataSourceImp
import com.example.moviescatalog.list_screen.data.repository.MoviesRepositoryImp
import com.example.moviescatalog.list_screen.domain.repository.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class MoviesListScreenModule {
    @Binds
    abstract fun bindRemoteDataSource(moviesDataSource: MoviesDataSourceImp): MoviesDataSource

    @Binds
    abstract fun bindHomeRepository(moviesRepository: MoviesRepositoryImp): MoviesRepository
}