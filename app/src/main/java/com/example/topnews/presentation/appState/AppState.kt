package com.example.topnews.presentation.appState

import com.example.topnews.presentation.list.NewsList

sealed class AppState{
    data class OnSuccess(
        val results: NewsList
    ) : AppState()

    object Loading : AppState()
    data class Error(val error: String) : AppState()
}
