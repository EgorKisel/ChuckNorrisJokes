package com.example.chucknorrisjokes.viewmodel

import com.example.chucknorrisjokes.repository.Joke

sealed class AppState {
    data class Success(val jokeData: Joke): AppState()
    data class Error(val error: Throwable): AppState()
    object Loading: AppState()
}
