package com.example.codelabretrofitexample.repository

import androidx.lifecycle.MutableLiveData
import com.example.codelabretrofitexample.MyApplication
import com.example.codelabretrofitexample.model.MarsProperties
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class Repository {
    val job= Job()
    val coroutineScope= CoroutineScope(Dispatchers.Main+job)
   fun getOverviewData(overViewLiveData:MutableLiveData<List<MarsProperties>>){
       coroutineScope.launch { overViewLiveData.postValue(MyApplication.apiservice.getApiOverViewData().await())


       }

    }
}