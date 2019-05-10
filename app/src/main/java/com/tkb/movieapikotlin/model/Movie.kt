package com.tkb.movie.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Wim on 5/29/17.
 */

class Movie : BaseModel<MovieData>() {

    @SerializedName("total_results")
    var totalResult: Int = 0
    @SerializedName("total_pages")
    var totalPages: Int = 0

}
