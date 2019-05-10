package com.tkb.movie.internet.network

import com.tkb.movie.model.*
import java.io.IOException
import java.util.concurrent.TimeUnit
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Wim on 6/2/17.
 */

class ApiService(internal var position: Int) {

    private val apiInterface: ApiInterface

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(builder())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        apiInterface = retrofit.create(ApiInterface::class.java!!)
    }

    private fun builder(): OkHttpClient {
        val okHttpClient = OkHttpClient().newBuilder()
        okHttpClient.connectTimeout(20, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(20, TimeUnit.SECONDS)
        okHttpClient.readTimeout(90, TimeUnit.SECONDS)

        okHttpClient.addInterceptor(interceptor())


        okHttpClient.addInterceptor { chain ->
            var request = chain.request()
            val url = request.url()
                    .newBuilder()
                    .addQueryParameter("api_key", Constant.API_KEY)
                    .addQueryParameter("language", Constant.LANG_EN)
                    .build()

            request = request.newBuilder().url(url).build()
            chain.proceed(request)
        }

        return okHttpClient.build()
    }

    private fun interceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return interceptor
    }

    fun getData(page: Int, callback: Callback<Movie>) {
        when (position) {
            0 -> getPopularMovies(page, callback)
            1 -> getTopRatedMovies(page, callback)
            2 -> getTopRatedMovies(page, callback)
            else -> getPopularMovies(page, callback)
        }
    }

    fun getPopularMovies(page: Int, callback: Callback<Movie>) {
        apiInterface.popularMovies(page).enqueue(callback)
    }

    fun getTopRatedMovies(page: Int, callback: Callback<Movie>) {
        apiInterface.getTopRatedMovies(page).enqueue(callback)
    }


    fun getMovieDetail(movieId: Int, callback: Callback<MovieDetail>) {
        apiInterface.movieDetail(movieId).enqueue(callback)
    }

    fun getTrailers(movieId: Int, callback: Callback<Trailer>) {
        apiInterface.trailers(movieId).enqueue(callback)
    }

    fun getReviews(movieId: Int, callback: Callback<Review>) {
        apiInterface.reviews(movieId).enqueue(callback)
    }
}
