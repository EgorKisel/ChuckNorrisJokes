package com.example.chucknorrisjokes.data

import com.example.chucknorrisjokes.repository.JokeResponse
import retrofit2.Call

class JokeRemoteDataSource(private val jokesAPI: JokesAPI) {
    fun getRandomJokeDataSource(): Call<JokeResponse> {
        return jokesAPI.getRandomJoke()
    }
}