package com.example.topnews.di

import androidx.appcompat.widget.AppCompatImageView
import com.example.topnews.presentation.loadImage.IImageLoader
import com.example.topnews.presentation.loadImage.ImageLoader
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ImageModule {
    @Singleton
    @Provides
    fun imageLoader(): IImageLoader<AppCompatImageView> = ImageLoader()
}