package com.example.codelabretrofitexample.service

import com.example.codelabretrofitexample.model.MarsProperties
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {
    @GET("realestate")
    fun getApiOverViewData():Deferred<List<MarsProperties>>
}