package com.tkb.movie.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Wim on 5/29/17.
 */

class Trailer : BaseModel<TrailerData>() {

    @SerializedName("id")
    var id: Int = 0

}
