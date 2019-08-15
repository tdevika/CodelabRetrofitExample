package com.example.codelabretrofitexample

import android.app.Application
import android.content.pm.ApplicationInfo
import com.example.codelabretrofitexample.service.ApiService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {
    companion object{lateinit var apiservice: ApiService}

    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://android-kotlin-fun-mars-server.appspot.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
        apiservice=retrofit.create(ApiService::class.java)
    }
}