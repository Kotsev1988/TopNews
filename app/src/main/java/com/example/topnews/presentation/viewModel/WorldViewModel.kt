package com.example.topnews.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.topnews.data.TopStoriesAPI
import javax.inject.Inject

class WorldViewModel @Inject constructor(
    private val topStories: TopStoriesAPI
): ViewModel() {


    fun init(){

    }

}