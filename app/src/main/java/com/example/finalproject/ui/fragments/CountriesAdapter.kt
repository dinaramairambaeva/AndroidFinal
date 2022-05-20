package com.example.finalproject.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.RowLayoutBinding
import com.example.finalproject.models.Countries

class CountriesAdapter(val clickListener: CountriesClickListener) : ListAdapter<Countries, CountriesAdapter.ViewHolder>(CountriesDiffCallback){
    companion object CountriesDiffCallback : DiffUtil.ItemCallback<Countries>(){
        override fun areItemsTheSame(oldItem: Countries, newItem: Countries) = oldItem.slug == newItem.slug
        override fun areContentsTheSame(oldItem: Countries, newItem: Countries) = oldItem == newItem
    }

    class ViewHolder(val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(countryEntry: Countries, clickListener: CountriesClickListener){
            binding.countryEntry = countryEntry
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = getItem(position)

        holder.bind(current, clickListener)
    }

}

class CountriesClickListener(val clickListener: (countryEntry: Countries) -> Unit){
    fun onClick(countryEntry: Countries) = clickListener(countryEntry)
}