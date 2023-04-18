package com.example.chucknorrisjokes.repository

sealed class JokesState {
    object Loading: JokesState()
    data class Success(val jokeResponse: String): JokesState()
    data class Error(val error: Throwable): JokesState()
}
