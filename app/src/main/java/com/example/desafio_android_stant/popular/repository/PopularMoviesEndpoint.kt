package com.example.desafio_android_stant.popular.repository

import com.example.desafio_android_stant.data.api.NetworkUtils
import com.example.desafio_android_stant.data.models.MovieContentModel
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularMoviesEndpoint {

    @GET("/popular")
    suspend fun getPopularMovies(
        @Query("api_key")api_key:String,
        @Query("language")language:String
    ) : MovieContentModel

    companion object {
        private const val BASE_URL_TMDB = "https://api.themoviedb.org/3/movie/popular/"
        val Endpoint: PopularMoviesEndpoint by lazy {
            NetworkUtils.getRetrofitInstance(BASE_URL_TMDB)
                .create(PopularMoviesEndpoint::class.java)
        }
    }




}