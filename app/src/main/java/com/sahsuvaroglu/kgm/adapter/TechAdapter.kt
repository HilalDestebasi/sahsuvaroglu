package com.sahsuvaroglu.kgm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sahsuvaroglu.kgm.R
import com.sahsuvaroglu.kgm.model.TechItem

class TechAdapter(
    private val dataList: List<TechItem>
) : RecyclerView.Adapter<TechAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val techTitle: TextView = itemView.findViewById(R.id.tech_title)
        val techInfo: TextView = itemView.findViewById(R.id.tech_info)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.tech_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.techTitle.text = item.title
        holder.techInfo.text = item.info
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
