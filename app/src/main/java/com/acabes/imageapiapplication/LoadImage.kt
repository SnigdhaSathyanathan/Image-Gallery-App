package com.acabes.imageapiapplication

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadImage(url:String){
    val errorImg=R.drawable.imgerror
    Picasso.get()
        .load(url)
        .placeholder(errorImg)
        .error(errorImg)
        .into(this)
}