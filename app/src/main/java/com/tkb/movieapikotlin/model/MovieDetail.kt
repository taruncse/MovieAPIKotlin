package com.tkb.movie.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Wim on 6/2/17.
 */

class MovieDetail {

    @SerializedName("id")
    var id: Int = 0
    @SerializedName("original_language")
    var originalLanguage: String? = null
    @SerializedName("original_title")
    var originalTitle: String? = null
    @SerializedName("overview")
    var overview: String? = null
    @SerializedName("poster_path")
    var posterPath: String? = null
    @SerializedName("release_date")
    var releaseDate: String? = null
    @SerializedName("runtime")
    var runtime: Int = 0
    @SerializedName("vote_average")
    var voteAverage: Double = 0.toDouble()
    @SerializedName("homepage")
    var homepage: String? = null
    @SerializedName("genres")
    var genres: List<Genre>? = null
}
