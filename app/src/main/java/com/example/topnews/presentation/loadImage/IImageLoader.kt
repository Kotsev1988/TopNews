package com.example.topnews.presentation.loadImage

interface IImageLoader<T> {
    fun loadAvatar(url: String, container: T)
}