package com.tkb.movie.internet.network

import com.tkb.movieapikotlin.BuildConfig
import java.util.ArrayList

/**
 * Created by Wim on 5/29/17.
 */

object Constant {

    val BASE_URL = BuildConfig.BASE_URL
    val IMG_URL = BuildConfig.IMG_URL
    val API_KEY = BuildConfig.MOVIE_API_KEY
    val VERSION = "/3"
    val MOVIE = "/movie"
    val VIDEOS = "videos"
    val REVIEWS = "reviews"
    val LANG_EN = "en-US"

    val MOVIE_PATH = VERSION + MOVIE

    val getApi: String
    get(){
       return MOVIE_PATH
    }

    val fragments: ArrayList<String>
        get() {

            val fragmentList = ArrayList<String>()
            fragmentList.add("Action")
            fragmentList.add("Adventure")
            fragmentList.add("Animation")
            fragmentList.add("Crime")
            fragmentList.add("Documentary")
            fragmentList.add("Drama")
            fragmentList.add("Family")
            fragmentList.add("Fantasy")
            fragmentList.add("Horror")
            fragmentList.add("Music")
            fragmentList.add("Mystery")
            fragmentList.add("Romance")
            fragmentList.add("Science Fiction")
            fragmentList.add("TV Movie")
            fragmentList.add("War")
            fragmentList.add("Western")

            return fragmentList
        }

}
