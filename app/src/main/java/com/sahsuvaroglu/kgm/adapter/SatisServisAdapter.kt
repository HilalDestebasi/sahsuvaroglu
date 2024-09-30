package com.sahsuvaroglu.kgm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sahsuvaroglu.kgm.databinding.SatisServisItemBinding
import com.sahsuvaroglu.kgm.model.SatisServisInfoModel

class SatisServisAdapter(private val locations: List<SatisServisInfoModel>) :
    RecyclerView.Adapter<SatisServisAdapter.LocationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val binding = SatisServisItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val location = locations[position]
        holder.bind(location)
    }

    override fun getItemCount(): Int = locations.size

    inner class LocationViewHolder(private val binding: SatisServisItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(location: SatisServisInfoModel) {
            binding.ssTitle.text = location.title
            binding.ssSatSer.text = location.satSer
            binding.ssAddress.text = location.address
            binding.ssTelephone.text = location.phone
        }
    }
}
