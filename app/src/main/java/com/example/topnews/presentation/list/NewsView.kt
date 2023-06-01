package com.example.topnews.presentation.list

interface NewsView: INewsView {
    fun setTitle(title: String)
    fun setImage(url: String)
    fun setDescription(desc: String)
    fun setCreatedDate(date: String)
}