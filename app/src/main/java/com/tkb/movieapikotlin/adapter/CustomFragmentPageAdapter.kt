package com.tkb.movie.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.tkb.movie.fragment.AllMovieFragment

import java.util.ArrayList

class CustomFragmentPageAdapter(fm: FragmentManager, fragmentList: List<String>) : FragmentStatePagerAdapter(fm) {
    val fragmentList: List<String>

    init {
        this.fragmentList = fragmentList
    }

    override fun getItem(position: Int): Fragment {

        return AllMovieFragment.newInstance(position)
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {

        return fragmentList[position]
    }

    companion object {

        private val fragmentList = ArrayList<String>()
    }
}
