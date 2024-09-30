package com.example.moviesapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.adapter.AdapterMovies
import com.example.moviesapp.databinding.ActivityMainBinding
import com.example.moviesapp.databinding.MoviesItemBinding
import com.example.moviesapp.model.Movie

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var adapterMovies: AdapterMovies
    private val movieList: MutableList<Movie> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerViewMovies = binding.recyclerViewMovies
        recyclerViewMovies.layoutManager = LinearLayoutManager(this)
        recyclerViewMovies.setHasFixedSize(true)

        adapterMovies = AdapterMovies(this, movieList)
        recyclerViewMovies.adapter = adapterMovies

        setItemList()
    }

    private fun setItemList() {
        val movie1 = Movie("Spider-man: 2")
        movieList.add(movie1)

        val movie2 = Movie("Clockwork orange")
        movieList.add(movie2)

        val movie3 = Movie("Fight Club")
        movieList.add(movie3)
    }
}