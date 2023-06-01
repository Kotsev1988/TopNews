package com.example.topnews.presentation.list

interface INewsItemList<V: INewsView> {

    var onItemClickListener: ((V) -> Unit)?

    fun bindView(view: V)
    fun getCount(): Int
}