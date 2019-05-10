package com.tkb.movie.adapter


import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.tkb.movieapikotlin.R

class DiscoverViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var playlistTitle: TextView
    var playlistTracks: TextView
    var playlistCover: ImageView

    init {

        playlistTitle = itemView.findViewById(R.id.play_list_name)
        playlistTracks = itemView.findViewById(R.id.number_of_tracks)
        playlistCover = itemView.findViewById(R.id.play_list_cover)
    }
}
