package com.example.chucknorrisjokes.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorrisjokes.data.JokeRemoteDataSource
import com.example.chucknorrisjokes.databinding.FragmentMainBinding
import com.example.chucknorrisjokes.repository.JokeResponse
import com.example.chucknorrisjokes.repository.JokeRetrofit
import com.example.chucknorrisjokes.viewmodel.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBarMain.visibility = View.VISIBLE

        val metod1: Call<JokeResponse> =
            JokeRemoteDataSource(JokeRetrofit.getJokeRetrofit()).getRandomJokeDataSource()
        metod1.enqueue(callback)


        binding.btnGetOtherJoke.setOnClickListener {
            val metod1: Call<JokeResponse> =
                JokeRemoteDataSource(JokeRetrofit.getJokeRetrofit()).getRandomJokeDataSource()
            metod1.enqueue(callback)
        }
    }

    private val callback = object : Callback<JokeResponse> {
        override fun onResponse(
            call: Call<JokeResponse>,
            response: Response<JokeResponse>
        ) {
            val serverResponse: JokeResponse? = response.body()
            serverResponse?.value
            renderData(serverResponse!!)
        }

        override fun onFailure(call: retrofit2.Call<JokeResponse>, t: Throwable) {
            Log.d("callback", "onFailure() called with: call = $call, t = $t")

        }
    }

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
}