package com.example.chucknorrisjokes.repository

import com.example.chucknorrisjokes.viewmodel.MainViewModel

interface JokesRepository {

    fun getJokes(callback: MainViewModel.Callback)
}