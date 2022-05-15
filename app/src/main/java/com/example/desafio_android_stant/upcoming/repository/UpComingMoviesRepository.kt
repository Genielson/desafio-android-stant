package com.example.desafio_android_stant.upcoming.repository

import com.example.desafio_android_stant.data.api.NetworkUtils
import com.example.desafio_android_stant.data.models.MovieContentModel
import com.example.desafio_android_stant.toprated.repository.TopRatedMoviesEndpoint

class UpComingMoviesRepository {

    private var client = UpComingMoviesEndpoint.endpoint
    suspend fun getListUpComingMovies(language:String): MovieContentModel {
        return client.getUpComingMovies(NetworkUtils.PUBLIC_KEY_API,language)
    }

}