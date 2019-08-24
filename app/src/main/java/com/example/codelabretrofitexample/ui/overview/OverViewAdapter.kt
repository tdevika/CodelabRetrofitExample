package com.example.codelabretrofitexample.ui.overview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codelabretrofitexample.databinding.OverviewItemBinding
import com.example.codelabretrofitexample.model.MarsProperties

class OverViewAdapter(var marsItem: List<MarsProperties>,val  onClickListner: ShekarClick) : RecyclerView.Adapter<OverViewViewHolder>() {


    fun updateAdapter(repository: List<MarsProperties>) {
        this.marsItem = repository
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverViewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = OverviewItemBinding.inflate(inflater, parent, false)
        return OverViewViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return marsItem.size
    }

    override fun onBindViewHolder(holder: OverViewViewHolder, position: Int) {
        val item = marsItem[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onClickListner.onClick(item)
        }
    }
}

class OverViewViewHolder(var binding: OverviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MarsProperties) {
        binding.modelData = item
    }
}

