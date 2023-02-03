package com.example.chucknorrisjokes.repository

data class Joke(val joke: ChuckNorrisJoke = getDefaultJoke())

data class ChuckNorrisJoke(
    val joke: String
)

fun getDefaultJoke() =
    ChuckNorrisJoke("Superman is able to leap tall buidings in a single bound. Chuck Norris is able to tell them to get the hell out of his way.")