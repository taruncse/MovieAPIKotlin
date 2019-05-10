package com.tkb.movie.adapter


import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.tkb.movie.entities.PlaylistObject
import com.tkb.movieapikotlin.R

class DiscoverAdapter(private val context: Context, private val playlists: List<PlaylistObject>) : RecyclerView.Adapter<DiscoverViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoverViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_discover, parent, false)
        return DiscoverViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiscoverViewHolder, position: Int) {
        val playlistObject = playlists[position]
        holder.playlistTitle.text = playlistObject.playlistTitle
        holder.playlistTracks.text = playlistObject.playlistTracks

    }

    override fun getItemCount(): Int {
        return playlists.size
    }

    companion object {

        private val TAG = DiscoverAdapter::class.java!!.getSimpleName()
    }
}
