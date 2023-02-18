package com.example.movies


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.movies.databinding.ActivityMainBinding
import com.example.movies.viewModel.MainViewModel

class MainActivity : AppCompatActivity(),LifecycleOwner {
    lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.ivArrow.setOnClickListener { searchMovie() }
        observeSearchedMovieLiveData()

    }

    private fun observeSearchedMovieLiveData() {
        viewModel.observeMovieDetailLiveData().observe(this) {movieList ->
//            if(movieList != null){
//                Glide.with(this@MainActivity)
//                    .load(movieList.i)
//                    .into(binding.ivMovieImage)
//                binding.tvId.text = movieList.id.toString()
//            }
            Log.d("vv",movieList.id.toString())
        }
    }


    private fun searchMovie() {
        val searchedMovie = binding.etSearchBox.toString()
        if(searchedMovie.isNotEmpty()){
            viewModel.getMovieDetail(searchedMovie)
        }

    }
}