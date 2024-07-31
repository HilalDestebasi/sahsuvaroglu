package com.sahsuvaroglu.kgm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

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

        if (position == carPrices.size - 1) {
            holder.separator.visibility = View.GONE
        } else {
            holder.separator.visibility = View.VISIBLE
        }
        if (position == carPrices.size - 1&&currentCarPrice.modelName=="Torres EVX 4x2 Elektrik") {
            holder.carName.visibility =View.GONE
            holder.carPrice.visibility=View.GONE
        }
    }

    override fun getItemCount(): Int {
        return carPrices.size
    }
}