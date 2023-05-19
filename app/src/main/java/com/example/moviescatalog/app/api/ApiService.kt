package com.example.moviescatalog.app.api

import com.example.moviescatalog.BuildConfig
import com.example.moviescatalog.app.models.BaseResponse
import com.example.moviescatalog.list_screen.data.models.MovieModel
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @Headers("Accept: application/json")
    @GET("movie")
    suspend fun getAllMovies(
        @Header("Authorization") token: String = "Bearer ${BuildConfig.API_KEY}",
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("include_video") includeVideo: Boolean = false,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int,
        @Query("sort_by") sortBy: String,
    ): Response<BaseResponse<ArrayList<MovieModel>>>

}