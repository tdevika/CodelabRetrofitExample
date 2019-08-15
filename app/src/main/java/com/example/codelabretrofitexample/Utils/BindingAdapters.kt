package com.example.codelabretrofitexample.Utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.codelabretrofitexample.R

@BindingAdapter("srcUrl")
fun bindImage(imgView: ImageView, imgUrl: String) {
    imgUrl.let {
        Glide.with(imgView.context)
                .load(imgUrl)
                .apply(RequestOptions()
                        .placeholder(R.drawable.placeholder)
                        .error(R.drawable.placeholder))
                .into(imgView)
    }
}