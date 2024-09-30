package com.sahsuvaroglu.kgm.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sahsuvaroglu.kgm.presentation.HardwareAndTechnicalPageActivity
import com.sahsuvaroglu.kgm.R
import com.sahsuvaroglu.kgm.model.CarModel


class CarModelAdapter(
    private val dataList: List<CarModel>
) : RecyclerView.Adapter<CarModelAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.car_model_subtitle)
        val img: ImageView = itemView.findViewById(R.id.car_model_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.car_model_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.title.text = item.title
        holder.img.setImageResource(item.img)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, HardwareAndTechnicalPageActivity::class.java).apply {
                putExtra("CAR_NAME", item.title)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
