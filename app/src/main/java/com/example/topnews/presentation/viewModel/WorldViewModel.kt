package com.example.topnews.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.topnews.data.TopStoriesAPI
import com.example.topnews.domain.models.Result
import com.example.topnews.presentation.appState.AppState
import com.example.topnews.presentation.list.NewsList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WorldViewModel @Inject constructor(
    private val topStories: TopStoriesAPI,
) : ViewModel() {

    private val _lists: MutableLiveData<AppState> = MutableLiveData()
    val listItem: LiveData<AppState>
        get() {
            return _lists
        }

    private val newsList = NewsList()
    fun init() {

        viewModelScope.launch {
            if (topStories.getWorldNews().isSuccessful) {
                val worldNews = topStories.getWorldNews().body()
                if (worldNews != null) {
                    newsList.results = worldNews.results as ArrayList<Result>
                    withContext(Dispatchers.Main) {
                        _lists.value = AppState.OnSuccess(newsList)
                    }
                }

            } else {
                withContext(Dispatchers.Main) {
                    _lists.value = AppState.Error("Empty data")
                }
            }

        }
    }
}