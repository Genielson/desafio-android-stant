package com.example.desafio_android_stant.popular.repository

import com.example.desafio_android_stant.data.api.NetworkUtils.Companion.PUBLIC_KEY

class PopularMoviesRepository {

    private var client = PopularMoviesEndpoint.Endpoint
    suspend fun getListPopularMovies(language:String){
        client.getPopularMovies(PUBLIC_KEY,language)
    }
}