package com.example.chucknorrisjokes.repository

interface Repository {

    fun getJokeFromServer(): Joke
    fun getJokeFromLocalStorage(): Joke
}