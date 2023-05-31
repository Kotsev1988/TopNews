package com.example.topnews.di

import androidx.lifecycle.ViewModel
import com.example.topnews.presentation.viewModel.WorldViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Singleton
    @Binds
    @IntoMap
    @ViewModelKey(WorldViewModel::class)
    internal abstract fun bindViewModel(viewModel: WorldViewModel): ViewModel
}