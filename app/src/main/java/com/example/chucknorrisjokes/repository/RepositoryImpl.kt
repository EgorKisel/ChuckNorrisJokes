package com.example.chucknorrisjokes.repository

class RepositoryImpl: Repository {
    override fun getJokeFromServer(): Joke {
        return Joke()
    }

    override fun getJokeFromLocalStorage(): Joke {
        return Joke()
    }
}