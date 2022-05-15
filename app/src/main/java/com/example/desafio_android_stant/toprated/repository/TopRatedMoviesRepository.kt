package com.example.desafio_android_stant.toprated.repository

import com.example.desafio_android_stant.data.api.NetworkUtils
import com.example.desafio_android_stant.data.models.MovieContentModel
import com.example.desafio_android_stant.popular.repository.PopularMoviesEndpoint

class TopRatedMoviesRepository {

    private var client = TopRatedMoviesEndpoint.endpoint
    suspend fun getListTopRatedMovies(language:String): MovieContentModel {
        return client.getTopRatedMovies(NetworkUtils.PUBLIC_KEY_API,language)
    }

}