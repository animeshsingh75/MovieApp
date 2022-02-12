package com.example.movieapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

@BindingAdapter("load")
fun loadImage(view: ImageView, url: String?) {

    url?.let {
        Glide.with(view)
            .load(it)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(view)
    }
}