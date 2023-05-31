package com.example.topnews.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.topnews.data.TopStoriesAPI
import kotlinx.coroutines.launch
import javax.inject.Inject

class WorldViewModel @Inject constructor(
    private val topStories: TopStoriesAPI,
) : ViewModel() {


    fun init() {

        viewModelScope.launch {
            val worldNews = topStories.getWorldNews().body()
            if (worldNews != null) {
                println("WORLD NEWS " + worldNews.results.toString())
                println("WORLD NEWS " + worldNews.results.size)
            }
        }
    }

}