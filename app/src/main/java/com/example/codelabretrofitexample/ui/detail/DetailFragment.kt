package com.example.codelabretrofitexample.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.codelabretrofitexample.R
import com.example.codelabretrofitexample.databinding.DetailLayoutBinding

class DetailFragment:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding=DataBindingUtil.inflate<DetailLayoutBinding>(inflater, R.layout.detail_layout,container,false)
        return binding.root

    }
}