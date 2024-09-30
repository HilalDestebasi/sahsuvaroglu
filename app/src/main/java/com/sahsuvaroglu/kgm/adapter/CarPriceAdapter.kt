package com.sahsuvaroglu.kgm.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sahsuvaroglu.kgm.R
import com.sahsuvaroglu.kgm.model.CarPrice

class CarPriceAdapter(private val carPrices: List<CarPrice>) : RecyclerView.Adapter<CarPriceAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carName: TextView = itemView.findViewById(R.id.car_name)
        val carPrice: TextView = itemView.findViewById(R.id.car_price)
        val separator: View = itemView.findViewById(R.id.car_price_separator)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car_price, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentCarPrice = carPrices[position]
        holder.carName.text = currentCarPrice.modelName
        holder.carPrice.text = currentCarPrice.price

        if (position == 0) {
            holder.carName.setTextColor(Color.parseColor("#302C4D"))
            holder.carPrice.setTextColor(Color.parseColor("#302C4D"))
        } else {
            holder.carName.setTextColor(Color.WHITE)
            holder.carPrice.setTextColor(Color.WHITE)
        }

    }

    override fun getItemCount(): Int {
        return carPrices.size
    }
}