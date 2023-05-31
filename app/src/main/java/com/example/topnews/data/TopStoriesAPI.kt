package com.example.topnews.data


import com.example.topnews.BuildConfig
import com.example.topnews.domain.models.WorldNews
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TopStoriesAPI {

    @GET("svc/topstories/v2/world.json")
    suspend fun getWorldNews(
        @Query("api-key") key: String = BuildConfig.NYT_API_KEY
    ): Response<WorldNews>
}