package com.example.topnews.di

import androidx.lifecycle.ViewModelProvider
import com.example.topnews.presentation.viewModel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}