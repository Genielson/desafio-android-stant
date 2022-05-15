package com.example.desafio_android_stant.toprated.repository

import com.example.desafio_android_stant.data.api.NetworkUtils
import com.example.desafio_android_stant.data.models.MovieContentModel
import com.example.desafio_android_stant.popular.repository.PopularMoviesEndpoint
import retrofit2.http.GET
import retrofit2.http.Query

interface TopRatedMoviesEndpoint {

    @GET("/3/movie/toprated")
    suspend fun getTopRatedMovies(
        @Query("api_key")api_key:String,
        @Query("language")language:String
    ) : MovieContentModel


    companion object {
        val endpoint: TopRatedMoviesEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(TopRatedMoviesEndpoint::class.java)
        }
    }

}