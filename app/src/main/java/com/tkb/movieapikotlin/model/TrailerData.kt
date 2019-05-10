package com.tkb.movie.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Wim on 5/29/17.
 */

class TrailerData {

    @SerializedName("id")
    var id: String? = null
    @SerializedName("key")
    var key: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("site")
    var site: String? = null
    @SerializedName("size")
    var size: Int = 0
    @SerializedName("type")
    var type: String? = null

}
