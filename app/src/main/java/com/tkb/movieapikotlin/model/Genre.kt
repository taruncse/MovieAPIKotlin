package com.tkb.movie.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Wim on 6/2/17.
 */

class Genre {

    @SerializedName("id")
    var id: Int = 0
    @SerializedName("name")
    var name: String? = null

}
