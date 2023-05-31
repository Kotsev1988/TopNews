package com.example.topnews.data

import com.example.topnews.domain.models.WorldNews
import com.example.topnews.domain.repository.IWorldNews
import retrofit2.Response

class GetWorldNewsImpl(private val api: TopStoriesAPI): IWorldNews {
    override suspend fun getWorldNews(): Response<WorldNews> = api.getWorldNews()
}