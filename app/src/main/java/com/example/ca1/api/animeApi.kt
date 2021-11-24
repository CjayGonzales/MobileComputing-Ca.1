package com.example.ca1.api

import com.example.ca1.data.AnimeResponse
import com.example.ca1.models.Post
import retrofit2.http.GET

interface animeApi {

    //details of API called that will be made
    //retrofit creates fun called getPosts()
    @GET("anime/")
    suspend fun getPosts(): AnimeResponse
}