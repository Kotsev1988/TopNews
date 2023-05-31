package com.example.topnews.di

import com.example.topnews.data.GetWorldNewsImpl
import com.example.topnews.data.TopStoriesAPI
import com.example.topnews.domain.repository.IWorldNews
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun getWorldNews(api: TopStoriesAPI): IWorldNews = GetWorldNewsImpl(api)
}