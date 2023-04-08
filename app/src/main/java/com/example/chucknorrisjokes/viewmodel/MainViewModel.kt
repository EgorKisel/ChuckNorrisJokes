package com.example.chucknorrisjokes.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chucknorrisjokes.repository.JokeResponse
import com.example.chucknorrisjokes.repository.RepositoryImpl
import java.lang.Thread.sleep

class MainViewModel(private val liveData: MutableLiveData<JokeResponse> = MutableLiveData(),
                    private val repositoryImpl: RepositoryImpl = RepositoryImpl()
): ViewModel() {

    fun getLivedata(): MutableLiveData<JokeResponse> {
        return liveData
    }

//    fun getJoke() {
//        Thread {
//            liveData.postValue(AppState.Loading)
//            sleep(2000L)
//            liveData.postValue(AppState.Success(repositoryImpl.getJokeFromLocalStorage()))
//        }.start()
//    }
}