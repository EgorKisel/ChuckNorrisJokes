package com.example.chucknorrisjokes

import com.example.chucknorrisjokes.ConstApi.MainApi
import com.example.chucknorrisjokes.data.JokeService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object JokeRetrofit {

    fun getWordRetrofit(): JokeService =
        Retrofit.Builder().baseUrl(MainApi)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build().create(JokeService::class.java)


    fun getWordRetrofitExample(): Retrofit =
        Retrofit.Builder().baseUrl(MainApi)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()
}
