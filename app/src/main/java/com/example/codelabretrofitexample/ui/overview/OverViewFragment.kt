package com.example.codelabretrofitexample.ui.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codelabretrofitexample.R
import com.example.codelabretrofitexample.databinding.OverviewLayoutBinding

class OverViewFragment:Fragment() {
    lateinit var binding:OverviewLayoutBinding
    lateinit var overviewViewModel:OverViewViewModel
    lateinit var overViewAdapter:OverViewAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         binding = DataBindingUtil.inflate<OverviewLayoutBinding>(inflater, R.layout.overview_layout, container, false)

      overViewAdapter=OverViewAdapter(emptyList())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        overviewViewModel= ViewModelProviders.of(this).get(OverViewViewModel::class.java)
        overviewViewModel.overViewLiveData.observe(this, Observer {
            it?.let {
               overViewAdapter.updateAdapter(it)
                var responce="Total property list is ${it.size}"
                binding.itemSize.text=responce
                binding.image.text=it[0].img_src

            }
        })
        uiData()


    }

    fun uiData(){
        with(binding.recyclerView){
            layoutManager=LinearLayoutManager(activity)
            adapter=overViewAdapter
        }
    }
}
