package com.example.chucknorrisjokes.repository

class RepositoryImpl: Repository {
    override fun getJokeFromServer() = Joke()

    override fun getJokeFromLocalStorage() = Joke()
}