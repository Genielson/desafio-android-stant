package com.example.desafio_android_stant.popular.repository

import com.example.desafio_android_stant.data.api.NetworkUtils
import com.example.desafio_android_stant.data.models.MovieContentModel
import com.example.desafio_android_stant.data.models.ResponseResultModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularMoviesEndpoint {

    @GET("/3/movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key")api_key:String,
        @Query("language")language:String
    ) : MovieContentModel


    companion object {
        val endpoint: PopularMoviesEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(PopularMoviesEndpoint::class.java)
        }
    }

}