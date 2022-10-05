package com.rodgim.cleanarchitecture.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rodgim.cleanarchitecture.R
import com.rodgim.cleanarchitecture.databinding.ViewLocationItemBinding
import kotlin.properties.Delegates

class LocationsAdapter : RecyclerView.Adapter<LocationsAdapter.ViewHolder>() {

    var items: List<Location> by Delegates.observable(emptyList()) {_, _, _ -> notifyDataSetChanged()}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(R.layout.view_location_item))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView) {
        val binding = ViewLocationItemBinding.bind(containerView)

        fun bind(location: Location) {
            with(location) {
                binding.locationCoordinates.text = coordinates
                binding.locationDate.text = date
            }
        }
    }
}