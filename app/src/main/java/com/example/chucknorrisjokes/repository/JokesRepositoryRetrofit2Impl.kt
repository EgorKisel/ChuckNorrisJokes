package com.example.chucknorrisjokes.repository

import android.util.Log
import com.example.chucknorrisjokes.Const.JOKES_DOMAIN
import com.example.chucknorrisjokes.data.JokesAPI
import com.example.chucknorrisjokes.viewmodel.MainViewModel
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokesRepositoryRetrofit2Impl : JokesRepository {
    override fun getJokes(callback: MainViewModel.Callback) {
        val jokesAPI = Retrofit.Builder().apply {
            baseUrl(JOKES_DOMAIN)
            addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        }.build().create(JokesAPI::class.java)

        jokesAPI.getRandomJoke().enqueue(object : Callback<JokeResponse> {
            override fun onResponse(call: Call<JokeResponse>, response: Response<JokeResponse>) {
                if (response.isSuccessful) {
                    val serverResponse: JokeResponse? = response.body()
                    serverResponse?.value
                }
            }

            override fun onFailure(call: Call<JokeResponse>, t: Throwable) {
                Log.d("callback", "onFailure() called with: call = $call, t = $t")
            }

        })
    }
}