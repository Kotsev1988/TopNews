package com.example.topnews.di

import com.example.topnews.data.TopStoriesAPI
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

    @Named("baseUrl")
    @Provides
    fun baseUrl(): String = "https://api.nytimes.com/"

    @Singleton
    @Provides
    fun api(@Named("baseUrl") baseUrl: String, gson: Gson): TopStoriesAPI {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(TopStoriesAPI::class.java)
    }

    @Singleton
    @Provides
    fun gson(): Gson = GsonBuilder().setLenient().create()
}