package com.example.movies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.movies.ModelClasses.D
import com.example.movies.databinding.MovieDetailItemViewBinding
import kotlin.time.measureTimedValue

class MovieDetailAdapter() :RecyclerView.Adapter<MovieDetailAdapter.MovieDetailViewHolder>(){
    private  var movieDetails = ArrayList<D>()

    fun setMovieDetail(movieDetail : ArrayList<D>){
        this.movieDetails = movieDetail
        notifyDataSetChanged()
    }
    class MovieDetailViewHolder( val binding: MovieDetailItemViewBinding):ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieDetailViewHolder {
        return MovieDetailViewHolder(MovieDetailItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MovieDetailViewHolder, position: Int) {
        if(movieDetails[position] != null){
            Glide.with(holder.itemView)
                .load(movieDetails[position].imageOfMovie.imageUrl)
                .into(holder.binding.ivMovieImage)
        }

        holder.binding.ivMovieName.text = movieDetails[position].movieName
        holder.binding.ivMovieStarCast.text = movieDetails[position].starCastOfMovie
        holder.binding.tvRank.text = movieDetails[position].rankOfMovie.toString()
        holder.binding.tvType.text = movieDetails[position].typeId
        holder.binding.tvYearOfRelease.text = movieDetails[position].yearOfRelease.toString()
    }

    override fun getItemCount(): Int {
       return movieDetails.size
    }

}