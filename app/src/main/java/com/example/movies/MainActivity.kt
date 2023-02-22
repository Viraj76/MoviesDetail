package com.example.movies


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movies.ModelClasses.D
import com.example.movies.adapters.MovieDetailAdapter
import com.example.movies.databinding.ActivityMainBinding
import com.example.movies.viewModel.MainViewModel

import kotlin.random.Random

class MainActivity : AppCompatActivity(),LifecycleOwner {
    lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainViewModel
    private lateinit var moviesDetailAdapter : MovieDetailAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        moviesDetailAdapter = MovieDetailAdapter()
        prepareMovieDetailRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
//        viewModel.getMovieDetail()
        binding.ivArrow.setOnClickListener { searchMovie() }
        observeSearchedMovieLiveData()
    }

    private fun prepareMovieDetailRecyclerView() {
        binding.rvMovieDetails.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,true)
            adapter = moviesDetailAdapter
        }
    }

    private fun observeSearchedMovieLiveData() {
        viewModel.observeMovieDetailLiveData().observe(this) { movieDetailList ->
//            val size = movieList.size
//            val random = Random.nextInt(0, size - 1
            // here we have used random number to access the data but be careful with displaying the data

//            if (movieList != null) {
//                Glide.with(this@MainActivity)
//                    .load(movieList[0].imageOfMovie.imageUrl)   // for this call image is missing then how we can fix it
//                    .into(binding.ivMovieImage)
//                binding.tvMovieName.text = movieList[0].movieName
//                binding.tvRank.text = movieList[0].rankOfMovie.toString()
//                binding.tvStarCast.text = movieList[0].starCastOfMovie
//                binding.tvType.text = movieList[0].typeId
//                binding.tvYear.text= movieList[0].yearOfRelease.toString()
//            }
            moviesDetailAdapter.setMovieDetail(movieDetailList as ArrayList<D>)
        }
    }

    private fun searchMovie() {
        val searchedMovie = binding.etSearchBox.text.toString()
        if(searchedMovie.isNotEmpty()){
            viewModel.getMovieDetail(searchedMovie)
        }

    }


}