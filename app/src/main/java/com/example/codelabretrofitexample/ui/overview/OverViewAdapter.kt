package com.example.codelabretrofitexample.ui.overview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.codelabretrofitexample.databinding.OverviewItemBinding
import com.example.codelabretrofitexample.model.MarsProperties

class OverViewAdapter(var marsItem: List<MarsProperties>) : RecyclerView.Adapter<OverViewViewHolder>() {
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
        var item = marsItem[position]
        holder.bind(item)
    }
}

class OverViewViewHolder(var binding: OverviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MarsProperties) {
        binding.modelData = item
    }
}