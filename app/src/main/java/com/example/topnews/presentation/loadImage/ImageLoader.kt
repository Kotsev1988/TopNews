package com.example.topnews.presentation.loadImage

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

class ImageLoader: IImageLoader<AppCompatImageView> {
    override fun loadAvatar(url: String, container: AppCompatImageView) {
        Glide.with(container.context)
            .load(url)
            .into(container)
    }
}