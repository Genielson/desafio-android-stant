package com.example.desafio_android_stant.upcoming.viewmodel

import androidx.lifecycle.*
import com.example.desafio_android_stant.upcoming.repository.UpComingMoviesRepository
import kotlinx.coroutines.Dispatchers

class UpComingViewModel(
    private var repository: UpComingMoviesRepository
    ) : ViewModel() {

    fun getListUpComingMovies() = liveData(Dispatchers.IO){
        var response = repository.getListUpComingMovies("en-US").result
        emit(response)
    }

    class UpComingViewModelFactory(private val repository: UpComingMoviesRepository):
        ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return UpComingViewModel(repository) as T
        }
    }

}