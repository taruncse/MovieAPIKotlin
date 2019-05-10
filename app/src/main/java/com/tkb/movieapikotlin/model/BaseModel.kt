package com.tkb.movie.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Wim on 5/29/17.
 */

open class BaseModel<T> {

    @SerializedName("page")
    var page: Int = 0
    @SerializedName("results")
    var results: List<T>? = null

}
