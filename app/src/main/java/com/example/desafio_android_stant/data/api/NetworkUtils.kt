package com.example.desafio_android_stant.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {

    companion object{
         const val BASE_URL = "https://api.themoviedb.org/3/movie/"
         const val PUBLIC_KEY = "f321a808e68611f41312aa8408531476"

        fun getRetrofitInstance(baseUrl:String) : Retrofit{
            return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).build()
        }
    }

}