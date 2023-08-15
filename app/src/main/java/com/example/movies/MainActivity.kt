package com.example.movies


import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.ModelClasses.D
import com.example.movies.adapters.MovieDetailAdapter
import com.example.movies.databinding.ActivityMainBinding
import com.example.movies.viewModel.MainViewModel

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

        binding.etSearchBox.requestFocus()
        binding.ivArrow.setOnClickListener {
            searchMovie()
            closeKeyboard()
        }

        observeSearchedMovieLiveData()

    }

    private fun closeKeyboard() {
        val view : View? = this.currentFocus
        val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        manager.hideSoftInputFromWindow(view!!.windowToken, 0)
    }

    private fun prepareMovieDetailRecyclerView() {
        binding.rvMovieDetails.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,true)
            adapter = moviesDetailAdapter
        }
    }

    private fun observeSearchedMovieLiveData() {
        viewModel.observeMovieDetailLiveData().observe(this) { movieDetailList ->
            movieDetailList.sortedByDescending { movies->
                movies.yearOfRelease
            }
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