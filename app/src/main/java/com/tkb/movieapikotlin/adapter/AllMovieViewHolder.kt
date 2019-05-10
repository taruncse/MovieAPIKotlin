package com.tkb.movie.adapter
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.tkb.movieapikotlin.R

class AllMovieViewHolder : RecyclerView.ViewHolder {

    var textTitle: TextView
    var textReleased: TextView
    var textRating: TextView
    var movieThum: ImageView

    constructor(itemView: View, textTitle: TextView, textReleased: TextView, movieThum: ImageView, textRating: TextView) : super(itemView) {
        this.textTitle = textTitle
        this.textReleased = textReleased
        this.movieThum = movieThum
        this.textRating = textRating
    }

    constructor(itemView: View) : super(itemView) {

        textTitle = itemView.findViewById(R.id.txt_title)
        textReleased = itemView.findViewById(R.id.txt_released)
        movieThum = itemView.findViewById(R.id.img_thumnail)
        textRating = itemView.findViewById(R.id.txt_rating)
    }
}
