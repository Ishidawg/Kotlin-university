package com.example.moviesapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.databinding.MoviesItemBinding
import com.example.moviesapp.model.Movie

class AdapterMovies(private val context: Context, private val movieList: MutableList<Movie>): RecyclerView.Adapter<AdapterMovies.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val listItem = MoviesItemBinding.inflate(LayoutInflater.from(context), parent, false)

        return MovieViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.movieTitle.text = movieList[position].title
    }

    override fun getItemCount() = movieList.size

    inner class MovieViewHolder(binding: MoviesItemBinding): RecyclerView.ViewHolder(binding.root) {
        val movieTitle = binding.movieTitle
    }
}