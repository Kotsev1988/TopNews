package com.example.topnews.di

import com.example.topnews.presentation.TopNewsFragment
import com.example.topnews.presentation.adapter.WorldNewsAdapter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ApiModule::class,
        DataModule::class,
        ViewModelModule::class,
        ViewModelFactoryModule::class,
        ImageModule::class
    ]
)

interface AppComponent {
    fun inject(topNewsFragment: TopNewsFragment)
    fun inject(worldNewsAdapter: WorldNewsAdapter)
}