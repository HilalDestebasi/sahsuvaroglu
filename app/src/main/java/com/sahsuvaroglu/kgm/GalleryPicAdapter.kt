package com.sahsuvaroglu.kgm

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class GalleryPicAdapter(private val images: List<Int>) : RecyclerView.Adapter<GalleryPicAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pic_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageRes = images[position]
        holder.imageView.setImageResource(imageRes)
        holder.imageView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, FullScreenImageActivity::class.java).apply {
                putExtra("image_res_id", imageRes)
                putExtra("image_style","gallery")
            }
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return images.size
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.gallery_pic)
    }
}
