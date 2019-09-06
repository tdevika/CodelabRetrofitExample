package com.example.realestatelist.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.realestatelist.R
import com.example.realestatelist.databinding.DetailLayoutBinding

class DetailFragment : Fragment() {
    lateinit var binding: DetailLayoutBinding
    lateinit var detailViewModel: DetailViewModel
    lateinit var detailViewModelFactory: DetailViewModelFactory
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.detail_layout, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var item = DetailFragmentArgs.fromBundle(arguments!!).selectedProperty
        detailViewModelFactory = DetailViewModelFactory(item, requireNotNull(activity).application)
        detailViewModel = ViewModelProviders.of(this,detailViewModelFactory).get(DetailViewModel::class.java)
        binding.detailViewModel = detailViewModel
        binding.lifecycleOwner = this
    }
}