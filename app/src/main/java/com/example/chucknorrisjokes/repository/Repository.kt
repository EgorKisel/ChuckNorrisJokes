package com.example.chucknorrisjokes.repository

interface Repository {

    fun getJokeFromServer(): Any
    fun getJokeFromLocalStorage(): Any
}