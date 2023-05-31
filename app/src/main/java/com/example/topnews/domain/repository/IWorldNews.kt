package com.example.topnews.domain.repository

import com.example.topnews.domain.models.WorldNews
import retrofit2.Response

interface IWorldNews {

    suspend fun getWorldNews(): Response<WorldNews>
}