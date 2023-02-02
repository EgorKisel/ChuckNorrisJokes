package com.example.chucknorrisjokes.repository

class RepositoryImpl: Repository {
    override fun getJokeFromServer(): Any {
        return Joke()
    }

    override fun getJokeFromLocalStorage(): Any {
        return Joke()
    }
}