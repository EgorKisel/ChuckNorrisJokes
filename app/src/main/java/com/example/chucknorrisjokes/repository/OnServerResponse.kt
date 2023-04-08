package com.example.chucknorrisjokes.repository

fun interface OnServerResponse {
    fun onResponse(jokeResponse: JokeResponse)
}