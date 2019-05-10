package com.tkb.movie.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.tkb.movie.adapter.DiscoverAdapter
import com.tkb.movie.entities.PlaylistObject
import com.tkb.movieapikotlin.R

import java.util.ArrayList


class DiscoverFragment : Fragment() {

    val testData: List<PlaylistObject>
        get() {
            val trackList = ArrayList<PlaylistObject>()
            trackList.add(PlaylistObject("Falling over", "12 tracks", ""))
            trackList.add(PlaylistObject("Falling over", "12 tracks", ""))
            trackList.add(PlaylistObject("Falling over", "12 tracks", ""))
            trackList.add(PlaylistObject("Falling over", "12 tracks", ""))
            trackList.add(PlaylistObject("Falling over", "12 tracks", ""))
            trackList.add(PlaylistObject("Falling over", "12 tracks", ""))
            trackList.add(PlaylistObject("Falling over", "12 tracks", ""))
            trackList.add(PlaylistObject("Falling over", "12 tracks", ""))
            return trackList
        }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_discover, container, false)

        val playlisRecyclerView = view.findViewById<RecyclerView>(R.id.your_play_list)
        val gridLayout = GridLayoutManager(activity, 2)
        playlisRecyclerView.layoutManager = gridLayout
        playlisRecyclerView.setHasFixedSize(true)

        val mAdapter = DiscoverAdapter(activity!!.baseContext, testData)
        playlisRecyclerView.adapter = mAdapter

        return view
    }
}
