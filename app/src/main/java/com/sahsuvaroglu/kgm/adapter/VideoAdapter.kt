package com.sahsuvaroglu.kgm.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.sahsuvaroglu.kgm.R
import com.sahsuvaroglu.kgm.presentation.VideoActivity
import com.sahsuvaroglu.kgm.model.VideoModel

class VideoAdapter(private val images: List<VideoModel>) : RecyclerView.Adapter<VideoAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.video_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageRes = images[position]
        holder.imageView.setImageResource(imageRes.pic)
        holder.imageView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, VideoActivity::class.java).apply {
                putExtra("video_url", imageRes.url)
            }
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return images.size
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.video_item_img)
    }
}
