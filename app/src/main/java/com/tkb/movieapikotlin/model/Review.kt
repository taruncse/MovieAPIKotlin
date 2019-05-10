package com.tkb.movie.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Wim on 5/29/17.
 */

class Review : BaseModel<ReviewData>() {

    @SerializedName("id")
    var id: Int = 0
    @SerializedName("total_pages")
    var totalPages: Int = 0
    @SerializedName("total_results")
    var totalResults: Int = 0
}
