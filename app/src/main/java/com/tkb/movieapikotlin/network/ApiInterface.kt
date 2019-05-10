package com.tkb.movie.internet.network

import com.tkb.movie.model.Movie
import com.tkb.movie.model.MovieDetail
import com.tkb.movie.model.Review
import com.tkb.movie.model.Trailer

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Wim on 6/2/17.
 */

interface ApiInterface {

    @GET("https://api.themoviedb.org/popular/3/movie")
    fun popularMovies(
            @Query("page") page: Int): Call<Movie>

    @GET("https://api.themoviedb.org/popular/3/movie/{movie_id}")
    fun movieDetail(
            @Path("movie_id") movieId: Int): Call<MovieDetail>

    @GET("https://api.themoviedb.org/popular/3/movie/{movie_id}/videos")
    fun trailers(
            @Path("movie_id") movieId: Int): Call<Trailer>

    @GET("https://api.themoviedb.org/popular/3/movie/{movie_id}/reviews")
    fun reviews(
            @Path("movie_id") movieId: Int): Call<Review>


    @GET("https://api.themoviedb.org/popular/3/movie/top_rated")
    fun getTopRatedMovies(@Query("page") page: Int): Call<Movie>

}
