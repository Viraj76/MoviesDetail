package com.example.movies.viewModel

import android.app.ProgressDialog
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.ModelClasses.AutoComplete
import com.example.movies.ModelClasses.D
import com.example.movies.Retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel :ViewModel() {

    private var movieDetailLiveData = MutableLiveData<List<D>>()

    fun getMovieDetail(movieName: String) {
        RetrofitInstance.api.getMovies(movieName)?.enqueue(object : Callback<AutoComplete?> {
            override fun onResponse(call: Call<AutoComplete?>, response: Response<AutoComplete?>) {
                val searchedMovie = response.body()?.d
                searchedMovie?.let {
                    movieDetailLiveData.postValue(it)
                }
            }
            override fun onFailure(call: Call<AutoComplete?>, t: Throwable) {
                Log.d("MainActivity", t.message.toString())
            }

        })
    }


    fun observeMovieDetailLiveData(): LiveData<List<D>> {
        return movieDetailLiveData
    }
}