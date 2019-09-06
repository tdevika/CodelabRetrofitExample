package com.example.realestatelist.ui.overview

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.realestatelist.R
import com.example.realestatelist.databinding.OverviewLayoutBinding
import com.example.realestatelist.model.MarsProperties
import com.example.realestatelist.service.Marsapifilter

class OverViewFragment : Fragment() {

    lateinit var binding: OverviewLayoutBinding
    lateinit var overviewViewModel: OverViewViewModel
    lateinit var overViewAdapter: OverViewAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.overview_layout, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        overviewViewModel = ViewModelProviders.of(this).get(OverViewViewModel::class.java)
        binding.viewModel = overviewViewModel
        binding.lifecycleOwner = this

       overviewViewModel.properties.observe(this, Observer {
           it?.let {
               binding.itemSize.text="Total MarsProperties are ${it.size.toString()}"
           }
       })
    }

    val clickListener = object : ShekarClick {
        override fun onClick(item: MarsProperties) {
            findNavController().navigate(OverViewFragmentDirections.actionShowDetails(item))

           // overviewViewModel.displayPropertyDetails(item)
            overviewViewModel.displayProprtydetaiscomplete()
        }
    }

    private fun initUi() {
        overViewAdapter = OverViewAdapter(emptyList(),clickListener )
        with(binding.recyclerView) {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = overViewAdapter
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.verflow_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        overviewViewModel.updateFilter(
                when (item.itemId) {
                    R.id.show_rent -> Marsapifilter.SHOW_RENT
                    R.id.show_buy -> Marsapifilter.SHOW_BUY
                    else -> Marsapifilter.SHOW_ALL
                })
        return true
    }

}
interface ShekarClick{
    fun onClick(item: MarsProperties)
}