package com.example.chucknorrisjokes.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chucknorrisjokes.JokeRetrofit
import com.example.chucknorrisjokes.data.JokeRemoteDataSource
import com.example.chucknorrisjokes.data.JokeService
import com.example.chucknorrisjokes.databinding.FragmentMainBinding
import com.example.chucknorrisjokes.repository.JokeResponse
import com.example.chucknorrisjokes.repository.OnServerResponse
import retrofit2.Call
import kotlin.concurrent.thread


class MainFragment : Fragment(), OnServerResponse {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.progressBarMain.visibility = View.VISIBLE
//
//
//        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
//        viewModel.getLivedata().observe(viewLifecycleOwner) { joke ->
//            renderData(joke)
//        }
//
//        JokeLoader(this@MainFragment).loadJoke()



        val retrofit = JokeRetrofit.getWordRetrofitExample()
        val userService: JokeService = retrofit.create(JokeService::class.java)



        binding.btnGetOtherJoke.setOnClickListener {
            //JokeLoader(this@MainFragment).loadJoke()
            thread {
//                val word: Call<JokeResponse> = userService.getWord()
//                word.enqueue(callback)

                var metod1: Call<JokeResponse> = JokeRemoteDataSource(JokeRetrofit.getWordRetrofit()).getWordDataSource()
                var categorii: Call<JokeResponse> = JokeRemoteDataSource(JokeRetrofit.getWordRetrofit()).getCategories()

                metod1.enqueue(callback)
            }
        }
    }
    private val callback = object : retrofit2.Callback<JokeResponse> {
        override fun onResponse(
            call: retrofit2.Call<JokeResponse>,
            response: retrofit2.Response<JokeResponse>
        ) {
            val serverResponse: JokeResponse? = response.body()
            serverResponse?.value


            renderData(serverResponse!!)
            Log.d("callback", "onResponse() called with: call = $call, response = $response")
            Log.d("callback", "serverResponse" + serverResponse.toString())
        }
        override fun onFailure(call: retrofit2.Call<JokeResponse>, t: Throwable) {
            Log.d("callback", "onFailure() called with: call = $call, t = $t")

        }
    }
//    private fun renderData(appState: AppState) {
//        when (appState) {
//            is AppState.Error -> binding.progressBarMain.visibility = View.GONE
//            is AppState.Loading -> binding.progressBarMain.visibility = View.VISIBLE
//            is AppState.Success -> {
//                binding.progressBarMain.visibility = View.GONE
//                binding.joke.text = "${appState.jokeData}"
//            }
//        }
//    }

    private fun renderData(jokeResponse: JokeResponse) {
        with(binding) {
            progressBarMain.visibility = View.GONE
            joke.text = jokeResponse.value
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onResponse(jokeResponse: JokeResponse) {
        renderData(jokeResponse)
    }
}