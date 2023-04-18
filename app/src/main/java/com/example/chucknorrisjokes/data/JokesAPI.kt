package com.example.chucknorrisjokes.data

import com.example.chucknorrisjokes.Const.RANDOM
import com.example.chucknorrisjokes.repository.JokeResponse
import retrofit2.Call
import retrofit2.http.GET

interface JokesAPI {

    @GET(RANDOM)
    fun getRandomJoke(): Call<JokeResponse>
}