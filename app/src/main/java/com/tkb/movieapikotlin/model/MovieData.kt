package com.tkb.movie.model

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.SerializedName

import java.util.ArrayList

/**
 * Created by Wim on 5/29/17.
 */

class MovieData : Parcelable {

    @SerializedName("id")
    var id: Int = 0
    @SerializedName("original_title")
    var originalTitle: String? = null
    @SerializedName("original_language")
    var originalLanguage: String? = null
    @SerializedName("title")
    var title: String? = null
    @SerializedName("poster_path")
    var posterPath: String? = null
    @SerializedName("adult")
    var isAdult: Boolean = false
    @SerializedName("overview")
    var overview: String? = null
    @SerializedName("release_date")
    var releaseDate: String? = null
    @SerializedName("genre_ids")
    var genreIds: List<Int>? = null
    @SerializedName("backdrop_path")
    var backdropPath: String? = null
    @SerializedName("popularity")
    var popularity: Double = 0.toDouble()
    @SerializedName("vote_count")
    var voteCount: Int = 0
    @SerializedName("video")
    var isVideo: Boolean = false
    @SerializedName("vote_average")
    var voteAverage: Double = 0.toDouble()

    constructor() {}

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(this.id)
        dest.writeString(this.originalTitle)
        dest.writeString(this.originalLanguage)
        dest.writeString(this.title)
        dest.writeString(this.posterPath)
        dest.writeByte(if (this.isAdult) 1.toByte() else 0.toByte())
        dest.writeString(this.overview)
        dest.writeString(this.releaseDate)
        dest.writeList(this.genreIds)
        dest.writeString(this.backdropPath)
        dest.writeDouble(this.popularity)
        dest.writeInt(this.voteCount)
        dest.writeByte(if (this.isVideo) 1.toByte() else 0.toByte())
        dest.writeDouble(this.voteAverage)
    }

    protected constructor(`in`: Parcel) {
        this.id = `in`.readInt()
        this.originalTitle = `in`.readString()
        this.originalLanguage = `in`.readString()
        this.title = `in`.readString()
        this.posterPath = `in`.readString()
        this.isAdult = `in`.readByte().toInt() != 0
        this.overview = `in`.readString()
        this.releaseDate = `in`.readString()
        this.genreIds = ArrayList()
        `in`.readList(this.genreIds, Int::class.java!!.getClassLoader())
        this.backdropPath = `in`.readString()
        this.popularity = `in`.readDouble()
        this.voteCount = `in`.readInt()
        this.isVideo = `in`.readByte().toInt() != 0
        this.voteAverage = `in`.readDouble()
    }

    companion object {

        val CREATOR: Parcelable.Creator<MovieData> = object : Parcelable.Creator<MovieData> {
            override fun createFromParcel(source: Parcel): MovieData {
                return MovieData(source)
            }

            override fun newArray(size: Int): Array<MovieData?> {
                return arrayOfNulls(size)
            }
        }
    }

}
