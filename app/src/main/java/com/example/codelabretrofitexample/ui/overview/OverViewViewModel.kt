package com.example.codelabretrofitexample.ui.overview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.codelabretrofitexample.model.MarsProperties
import com.example.codelabretrofitexample.repository.Repository

class OverViewViewModel:ViewModel() {
val overViewLiveData= MutableLiveData<List<MarsProperties>>()
    val imageData=MutableLiveData<String>()
    val repository=Repository()
    init {
        repository.getOverviewData(overViewLiveData)
    }
}