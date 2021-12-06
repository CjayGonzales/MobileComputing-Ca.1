package com.example.ca1.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://api.aniapi.com/v1/"
object RetrofitInstance {

    //retrofit instance
    private val retrofit by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        // builds
        Retrofit.Builder()
            // base url
            .baseUrl(BASE_URL)
            // moshi converter
            .addConverterFactory(MoshiConverterFactory.create())
            .client(httpClient.build())

            //builds it
            .build()
    }

    // this makes the retrofit var public and will pass the animeAPI to the java class
    val api: animeApi by lazy{
        retrofit.create(animeApi::class.java)
    }
}