package com.example.chucknorrisjokes.viewmodel

sealed class AppState {
    data class Success(val jokeData: Any): AppState()
    data class Error(val error: Throwable): AppState()
    object Loading: AppState()
}
