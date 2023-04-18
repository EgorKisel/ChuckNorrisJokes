package com.example.chucknorrisjokes.repository

import com.example.chucknorrisjokes.Const.JOKES_DOMAIN
import com.example.chucknorrisjokes.data.JokesAPI
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object JokeRetrofit {

    fun getJokeRetrofit(): JokesAPI = Retrofit.Builder().baseUrl(JOKES_DOMAIN)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build().create(JokesAPI::class.java)

    fun getWordRetrofitExample(): Retrofit =
        Retrofit.Builder().baseUrl(JOKES_DOMAIN)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()
}