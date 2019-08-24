package com.example.codelabretrofitexample.ui.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.codelabretrofitexample.MyApplication
import com.example.codelabretrofitexample.model.MarsProperties
import java.lang.IllegalArgumentException

class DetailViewModelFactory(val marsProperties: MarsProperties, val app:Application):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(marsProperties,app) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}