package com.vision.cleancare.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {
    @GET("products/1")
    suspend fun getAllMovies() : Response<ResponseBody>

}