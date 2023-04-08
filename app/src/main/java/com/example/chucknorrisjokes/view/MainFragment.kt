package com.example.chucknorrisjokes.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorrisjokes.R
import com.example.chucknorrisjokes.databinding.FragmentMainBinding
import com.example.chucknorrisjokes.repository.Joke
import com.example.chucknorrisjokes.repository.JokeLoader
import com.example.chucknorrisjokes.repository.JokeResponse
import com.example.chucknorrisjokes.repository.OnServerResponse
import com.example.chucknorrisjokes.viewmodel.AppState
import com.example.chucknorrisjokes.viewmodel.MainViewModel

class MainFragment : Fragment(), OnServerResponse {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val observer =
            Observer<JokeResponse> { joke -> renderData(joke) }
        viewModel.getLivedata().observe(viewLifecycleOwner, observer)
//        viewModel.getJoke()
        binding.progressBarMain.visibility = View.VISIBLE
        JokeLoader(this@MainFragment).loadJoke()

        binding.btnGetOtherJoke.setOnClickListener {
            JokeLoader(this@MainFragment).loadJoke()
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