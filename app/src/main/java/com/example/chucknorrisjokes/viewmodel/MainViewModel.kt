package com.example.chucknorrisjokes.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val liveData: MutableLiveData<Any>): ViewModel() {

    fun getLivedata(): MutableLiveData<Any> {
        return liveData
    }

    fun getJoke() {}
}