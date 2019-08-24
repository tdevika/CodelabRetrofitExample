package com.example.codelabretrofitexample.service

import com.example.codelabretrofitexample.model.MarsProperties
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

enum class Marsapifilter(val value:String){
    SHOW_RENT("rent"),
    SHOW_BUY("buy"),
    SHOW_ALL("all")
}
interface ApiService {
    @GET("realestate")
    fun getApiOverViewData(@Query("filter") filterType:String):Deferred<List<MarsProperties>>
}