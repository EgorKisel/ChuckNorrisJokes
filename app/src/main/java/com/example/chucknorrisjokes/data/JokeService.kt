package com.example.chucknorrisjokes.data

import com.example.chucknorrisjokes.ConstApi.CATEGORIES
import com.example.chucknorrisjokes.ConstApi.RANDOM
import com.example.chucknorrisjokes.repository.JokeResponse
import retrofit2.Call
import retrofit2.http.GET

interface JokeService {
    @GET(RANDOM)
    fun getWord(): Call<JokeResponse>
    @GET(CATEGORIES)
    fun getCategories(): Call<JokeResponse>
}