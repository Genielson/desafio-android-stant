package com.example.desafio_android_stant.popular.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.desafio_android_stant.popular.repository.PopularMoviesRepository
import kotlinx.coroutines.Dispatchers

class PopularViewModel(
    var repository: PopularMoviesRepository) : ViewModel() {
    fun getListPopularMovies() = liveData(Dispatchers.IO){
        var response = repository.getListPopularMovies("en-US").result
        emit(response)
    }

    class PopularViewModelFactory(private val repository: PopularMoviesRepository):ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return PopularViewModel(repository) as T
        }
    }
}