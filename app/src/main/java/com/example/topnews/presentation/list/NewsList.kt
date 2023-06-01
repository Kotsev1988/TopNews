package com.example.topnews.presentation.list

import com.example.topnews.domain.models.Result

class NewsList() : NewsItemList {

    override var onItemClickListener: ((NewsView) -> Unit)? = null

    var results: ArrayList<Result> = arrayListOf()

    override fun bindView(view: NewsView) {

        val resultItem = results[view.pos]

        view.setTitle(resultItem.title)

        view.setDescription(resultItem.abstract)

        view.setImage(resultItem.multimedia.get(0).url)

        view.setCreatedDate(resultItem.created_date)

    }

    override fun getCount(): Int = results.size
}