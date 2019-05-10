package com.tkb.movie.fragment

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.tkb.movie.adapter.CustomFragmentPageAdapter
import com.tkb.movie.internet.network.Constant
import com.tkb.movieapikotlin.R


class PopularMovieFragment : Fragment() {

    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_popular_movie, container, false)

        tabLayout = view.findViewById(R.id.tabs)
        viewPager = view.findViewById(R.id.view_pager)

        viewPager!!.adapter = CustomFragmentPageAdapter(childFragmentManager, Constant.fragments)
        tabLayout!!.setupWithViewPager(viewPager)
        tabLayout!!.tabMode = TabLayout.MODE_SCROLLABLE
        return view
    }

    companion object {

        private val TAG = PopularMovieFragment::class.java!!.getSimpleName()
    }
}
