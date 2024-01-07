package com.vision.cleancare.network.repository

import com.vision.cleancare.network.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {
    suspend fun getAllMovies() = retrofitService.getAllMovies()
}