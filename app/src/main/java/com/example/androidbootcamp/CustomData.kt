package com.example.androidbootcamp

import android.widget.ImageView
import android.widget.RatingBar

data class CustomData(
    val title : String,
    var subtitle : String,
    var image : ImageView,
    var ratingBar: RatingBar,
    var reviews : String ,
    var  list : String
)
