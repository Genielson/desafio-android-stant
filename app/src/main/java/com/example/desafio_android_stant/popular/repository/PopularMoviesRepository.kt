package com.example.desafio_android_stant.popular.repository

import com.example.desafio_android_stant.data.api.NetworkUtils.Companion.PUBLIC_KEY_API
import com.example.desafio_android_stant.data.models.MovieContentModel
import javax.crypto.Cipher.PUBLIC_KEY

class PopularMoviesRepository {

    private var client = PopularMoviesEndpoint.endpoint
    suspend fun getListPopularMovies(language:String): MovieContentModel {
        return client.getPopularMovies(PUBLIC_KEY_API,language)
    }
}