package com.tkb.movieapikotlin

import com.tkb.movie.fragment.PopularMovieFragment
import com.tkb.movie.fragment.DiscoverFragment

import androidx.fragment.app.Fragment

object FragmentsManager {

    fun getFragment(id: Int): Fragment? {
        if (id == R.id.popular_movies) {
            return PopularMovieFragment()
        } else if (id == R.id.discover_movies) {
            return DiscoverFragment()
        } else if (id == R.id.upcoming_movies) {
            return DiscoverFragment()

        } else if (id == R.id.now_playing) {
            return DiscoverFragment()

        } else if (id == R.id.top_rated) {
            return DiscoverFragment()
        }
        return null
    }
}
