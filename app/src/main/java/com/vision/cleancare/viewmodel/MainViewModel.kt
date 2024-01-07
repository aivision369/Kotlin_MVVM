package com.vision.cleancare.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vision.cleancare.network.model.Movie
import com.vision.cleancare.network.repository.MainRepository
import kotlinx.coroutines.*
import okhttp3.ResponseBody

class MainViewModel constructor(private val mainRepository: MainRepository): ViewModel() {


    val errorMessage = MutableLiveData<String>()
    val movieList = MutableLiveData<ResponseBody>()
    var job: Job? = null

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()

    init {
        loading.postValue(true)
    }
    fun getAllMovies() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = mainRepository.getAllMovies()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    movieList.postValue(response.body())
                    loading.postValue( false)
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }

    }

    private fun onError(message: String) {
        errorMessage.postValue(message)
        loading.postValue( false)
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}