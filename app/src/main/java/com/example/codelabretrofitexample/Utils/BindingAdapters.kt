package com.example.codelabretrofitexample.Utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.codelabretrofitexample.R
import com.example.codelabretrofitexample.model.MarsProperties
import com.example.codelabretrofitexample.ui.overview.MarsApiStatus
import com.example.codelabretrofitexample.ui.overview.OverViewAdapter

@BindingAdapter("iUrl")
fun bindImage(imgView: ImageView, iiUrl: String) {
    iiUrl.let {
        Glide.with(imgView.context)
                .load(iiUrl)
                .apply(RequestOptions()
                        .placeholder(R.drawable.placeholder)
                        .error(R.drawable.placeholder))
                .into(imgView)
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MarsProperties>?) {
    val adapter = recyclerView.adapter as OverViewAdapter
    data?.let {  adapter.updateAdapter(it)}
}

@BindingAdapter("marsApiStatus")
fun bindStatus(statusImageView: ImageView, status: MarsApiStatus?) {
    when (status) {
        MarsApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        MarsApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        MarsApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}