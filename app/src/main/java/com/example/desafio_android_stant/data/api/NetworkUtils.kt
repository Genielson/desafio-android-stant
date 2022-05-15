package com.example.desafio_android_stant.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {

    companion object{
        val PUBLIC_KEY_API = "f321a808e68611f41312aa8408531476"
        private const val BASE_URL = "https://api.themoviedb.org"
        fun getRetrofitInstance(): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}