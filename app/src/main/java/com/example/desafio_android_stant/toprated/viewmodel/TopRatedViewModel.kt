package com.example.desafio_android_stant.toprated.viewmodel

import androidx.lifecycle.*
import com.example.desafio_android_stant.popular.repository.PopularMoviesRepository
import com.example.desafio_android_stant.popular.viewmodel.PopularViewModel
import com.example.desafio_android_stant.toprated.repository.TopRatedMoviesRepository
import kotlinx.coroutines.Dispatchers

class TopRatedViewModel(
    var repository: TopRatedMoviesRepository
) : ViewModel() {

    fun getListTopRatedMovies() = liveData(Dispatchers.IO){
        var response = repository.getListTopRatedMovies("en-US").result
        emit(response)
    }

    class TopRatedViewModelFactory(private val repository: TopRatedMoviesRepository):ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return TopRatedViewModel(repository) as T
        }
    }


}