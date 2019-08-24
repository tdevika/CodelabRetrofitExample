package com.example.codelabretrofitexample.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarsProperties(
        val id: String,
        val img_src: String,
        val price: Int,
        val type: String) : Parcelable {
    val isRental:Boolean
        get()=type=="rent"
}

