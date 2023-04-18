package com.example.chucknorrisjokes.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chucknorrisjokes.repository.JokesRepository
import com.example.chucknorrisjokes.repository.JokesRepositoryRetrofit2Impl
import com.example.chucknorrisjokes.repository.JokesState

class MainViewModel(private val liveData: MutableLiveData<JokesState> = MutableLiveData(),
                    private val repository: JokesRepository = JokesRepositoryRetrofit2Impl()
): ViewModel() {

    fun getLivedata() = liveData

    fun getJoke() {
        repository.getJokes(object : Callback {
            override fun onResponse(jokeResponse: String) {
                liveData.postValue(JokesState.Success(jokeResponse))
            }

            override fun onFail() {
                //"Not yet implemented"
            }

        })
    }

    interface Callback {
        fun onResponse(jokeResponse: String)
        fun onFail()
    }
}