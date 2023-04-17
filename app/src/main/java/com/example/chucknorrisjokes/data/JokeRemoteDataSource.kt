package com.example.chucknorrisjokes.data

import com.example.chucknorrisjokes.repository.JokeResponse
import retrofit2.Call

class JokeRemoteDataSource(private val jokeService: JokeService) {
    fun getWordDataSource(): Call<JokeResponse> {
        return jokeService.getWord()
    }

    fun getCategories(): Call<JokeResponse> {
        return jokeService.getCategories()
    }
}