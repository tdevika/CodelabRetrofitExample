package com.example.realestatelist.ui.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.realestatelist.MyApplication
import com.example.realestatelist.model.MarsProperties
import com.example.realestatelist.service.Marsapifilter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

enum class MarsApiStatus { LOADING, ERROR, DONE }

class OverViewViewModel : ViewModel() {
    private  val job = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + job)
    private val overViewLiveData = MutableLiveData<List<MarsProperties>>()
    private val _status = MutableLiveData<MarsApiStatus>()
    val status: LiveData<MarsApiStatus>
        get() = _status
    val properties: LiveData<List<MarsProperties>>
        get() = overViewLiveData
    var navigationToSelectedProperty=MutableLiveData<MarsProperties>()
    val navigationtoSelectedProperty:LiveData<MarsProperties>
    get()=navigationToSelectedProperty


    init {
        getMarsRealEstateProperties(Marsapifilter.SHOW_ALL)
    }
    fun getMarsRealEstateProperties(filter:Marsapifilter) {
        coroutineScope.launch {
            try {
                _status.value = MarsApiStatus.LOADING
                overViewLiveData.value = MyApplication.apiservice.getApiOverViewData(filter.value).await()
                _status.value = MarsApiStatus.DONE

            } catch (e: Exception) {
                _status.value = MarsApiStatus.ERROR
                overViewLiveData.value = ArrayList()
            }
        }
    }


    fun updateFilter(filter: Marsapifilter){
        getMarsRealEstateProperties(filter)
    }

    fun displayProprtydetaiscomplete(){
        navigationToSelectedProperty.value=null
    }

    fun displayPropertyDetails(marsProperty:MarsProperties) {
        navigationToSelectedProperty.value=marsProperty

    }
}