package com.tkb.movie.fragment

import android.os.Handler
import android.util.Log

import com.tkb.movie.model.Movie
import com.tkb.movie.model.MovieData
import com.tkb.movie.internet.network.ApiService

import java.net.SocketTimeoutException
import java.util.HashMap

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllMovieViewModel : ViewModel() {

    private val TAG = AllMovieViewModel::class.java!!.getSimpleName()
    internal var handler = Handler() // new handler

    private var movieList: MutableLiveData<HashMap<Int, List<MovieData>>>? = null
    internal var singleData = HashMap<Int, List<MovieData>>()
    internal var i = 0
    internal var position: Int = 0
    internal var pageNumber: Int = 0
    internal fun getMovie(position: Int, pageNumber: Int): LiveData<HashMap<Int, List<MovieData>>> {
        this.position = position
        this.pageNumber = pageNumber

        Log.d(TAG, position.toString() + "")
        if (movieList == null) {
            movieList = MutableLiveData()
            loadData()
        }
        return movieList as MutableLiveData<HashMap<Int, List<MovieData>>>
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "on cleared called")
    }


    private fun loadData() {


        val apiService = ApiService(position)



        apiService.getData(pageNumber, object : Callback<Movie> {
            override fun onFailure(call: Call<Movie>, t: Throwable) {
                if (t is SocketTimeoutException) {
                    //Toast.makeText(getContext(), "Request Timeout. Please try again!", Toast.LENGTH_LONG).show();
                } else {
                    //Toast.makeText(getContext(), "Connection Error!", Toast.LENGTH_LONG).show();
                }            }

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                val movie = response.body() as Movie?

                if (movie != null) {
                    //singleData[position] = movie.results
                    singleData.put(position,movie.results!!)
                    movieList!!.setValue(singleData)
                }
            }
        })
    }
}