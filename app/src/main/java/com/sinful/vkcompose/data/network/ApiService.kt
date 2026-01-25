package com.sinful.vkcompose.data.network

import com.sinful.vkcompose.data.model.NewsItemsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("latest")
    suspend fun loadNews(
        @Query("apikey") token: String,
        @Query("q") theme: String
    ): NewsItemsResponseDto
}