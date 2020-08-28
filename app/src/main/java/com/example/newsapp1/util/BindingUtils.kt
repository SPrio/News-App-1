package com.example.newsapp1.util

import android.annotation.SuppressLint
import android.os.Build
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat

@BindingAdapter("image")
fun loadImage(view: ImageView, url: String) {
    Glide.with(view)
        .load(url)
        .into(view)
}

@SuppressLint("SimpleDateFormat")
@RequiresApi(Build.VERSION_CODES.O)
@BindingAdapter("publishedAt")
fun convertTime(view: TextView, time: String){
    val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    val formatter = SimpleDateFormat("dd.MM.yyyy HH:mm")
    val output: String = formatter.format(parser.parse(time)!!)
    view.text = output
}
