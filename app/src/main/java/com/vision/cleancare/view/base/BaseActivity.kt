package com.vision.cleancare.view.base

import androidx.appcompat.app.AppCompatActivity
import com.vision.cleancare.network.ApiClient
import com.vision.cleancare.network.repository.MainRepository


open class BaseActivity : AppCompatActivity() {
    //Implement global level uses here, so we can use in whole app
    private val retrofitService = ApiClient().getInstance()
    val mainRepository = MainRepository(retrofitService)
}