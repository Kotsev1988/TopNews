package com.example.topnews.di

import com.example.topnews.presentation.TopNewsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, ApiModule::class, DataModule::class, ViewModelModule::class]
)

interface AppComponent {

    fun inject(topNewsFragment: TopNewsFragment)
}