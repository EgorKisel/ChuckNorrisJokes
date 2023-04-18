package com.example.chucknorrisjokes.repository

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class JokeLoader(private val onServerResponseListener: OnServerResponse) {

    fun loadJoke() {

        val urlText = "https://api.chucknorris.io/jokes/random"
        val uri = URL(urlText)
        val urlConnection: HttpsURLConnection = (uri.openConnection() as HttpsURLConnection)

        Thread {
            try {
                val headers = urlConnection.headerFields
                val responseCode = urlConnection.responseCode
                val buffer = BufferedReader(InputStreamReader(urlConnection.inputStream))
                val jokeResponse: JokeResponse = Gson().fromJson(buffer, JokeResponse::class.java)
                Handler(Looper.getMainLooper()).post {
                    onServerResponseListener.onResponse(jokeResponse)
                }
            } catch (e: Exception) {
                Log.e("", "Fail URI", e)
                e.printStackTrace()
            } finally {
                urlConnection.disconnect()
            }
        }.start()
    }
}