package com.sahsuvaroglu.kgm

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ColorAdapter(private val images: List<ColorModel>) : RecyclerView.Adapter<ColorAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.color_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageRes = images[position]
        holder.imageView.setImageResource(imageRes.pic)
        holder.textView.text = imageRes.name
        holder.imageView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, FullScreenImageActivity::class.java).apply {
                putExtra("image_res_id", imageRes.pic)
                putExtra("image_style","color")
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return images.size
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.color_item_img)
        val textView: TextView = itemView.findViewById(R.id.color_item_text)
    }
}
