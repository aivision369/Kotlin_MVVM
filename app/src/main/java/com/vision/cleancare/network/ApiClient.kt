package com.vision.cleancare.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.vision.cleancare.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient

import java.util.concurrent.TimeUnit


class ApiClient {
    var retrofitService: RetrofitService? = null


    fun getInstance(): RetrofitService {
        val builder: OkHttpClient.Builder = OkHttpClient().newBuilder()
        builder.readTimeout(10, TimeUnit.SECONDS)
        builder.connectTimeout(5, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            builder.addInterceptor(interceptor)
        }

        //Extra Headers

        //builder.addNetworkInterceptor().add(chain -> {
        //  Request request = chain.request().newBuilder().addHeader("Authorization", authToken).build();
        //  return chain.proceed(request);
        //});


        //Extra Headers

        //builder.addNetworkInterceptor().add(chain -> {
        //  Request request = chain.request().newBuilder().addHeader("Authorization", authToken).build();
        //  return chain.proceed(request);
        //});

        //builder.addInterceptor(UnauthorisedInterceptor(context))

        val client: OkHttpClient = builder.build()
        /*if (BuildConfig.DEBUG) {
            val interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(interceptor);
        }*/

        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()
        if (retrofitService == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://dummyjson.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            retrofitService = retrofit.create(RetrofitService::class.java)
        }
        return retrofitService!!
    }
}