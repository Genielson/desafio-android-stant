package com.example.desafio_android_stant.upcoming.repository

import com.example.desafio_android_stant.data.api.NetworkUtils
import com.example.desafio_android_stant.data.models.MovieContentModel
import com.example.desafio_android_stant.toprated.repository.TopRatedMoviesEndpoint
import retrofit2.http.GET
import retrofit2.http.Query

interface UpComingMoviesEndpoint {

    @GET("/3/movie/upcoming")
    suspend fun getTopRatedMovies(
        @Query("api_key")api_key:String,
        @Query("language")language:String
    ) : MovieContentModel


    companion object {
        val endpoint: UpComingMoviesEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(UpComingMoviesEndpoint::class.java)
        }
    }

}