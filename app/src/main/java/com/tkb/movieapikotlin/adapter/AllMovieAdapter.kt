package com.tkb.movie.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.tkb.movie.model.MovieData

import java.util.ArrayList

import androidx.recyclerview.widget.RecyclerView
import com.tkb.movieapikotlin.R

class AllMovieAdapter(private val context: Context) : RecyclerView.Adapter<AllMovieViewHolder>() {
    private val allMovies = ArrayList<MovieData>()
    fun addItems(items: List<MovieData>) {
        this.allMovies.addAll(items)
    }

    fun addSingleItem(item: MovieData) {
        this.allMovies.add(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllMovieViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_movie, parent, false)
        return AllMovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: AllMovieViewHolder, position: Int) {
        val songs = allMovies[position]
        holder.textTitle.text = songs.title
        holder.textReleased.text = songs.releaseDate
    }

    override fun getItemCount(): Int {
        return allMovies.size
    }

}
