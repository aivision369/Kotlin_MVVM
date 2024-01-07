package com.vision.cleancare.network

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vision.cleancare.network.repository.MainRepository
import com.vision.cleancare.viewmodel.MainViewModel
import java.lang.IllegalArgumentException

class ContextViewModelFactory(private val context: Context, private val repository: MainRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ContextViewModelFactory, Error:Unknown ViewModel class::")
        }
    }
}