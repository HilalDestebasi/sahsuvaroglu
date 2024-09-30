package com.sahsuvaroglu.kgm.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sahsuvaroglu.kgm.R
import com.sahsuvaroglu.kgm.adapter.ColorAdapter
import com.sahsuvaroglu.kgm.adapter.GalleryPicAdapter
import com.sahsuvaroglu.kgm.adapter.VideoAdapter
import com.sahsuvaroglu.kgm.databinding.ActivityGalleryBinding
import com.sahsuvaroglu.kgm.model.ColorModel
import com.sahsuvaroglu.kgm.model.VideoModel
import com.sahsuvaroglu.kgm.util.showPopup

class GalleryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGalleryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        window.decorView.apply {
            systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val carName = intent.getStringExtra("CAR_NAME")
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        binding.galleryBackIcon.setOnClickListener {
            finish()
        }

        binding.gallerySgLogo.setOnClickListener {
            showPopup(it, this)
        }

        setContentView(binding.root)


        val images: List<ColorModel>
        val gallery: List<Int>
        val videos: List<VideoModel>

        when (carName) {
            "Torres" -> {
                images = listOf(ColorModel(R.drawable.torres1,"Grand Beyaz"), ColorModel(R.drawable.torres2,"Amazon Yeşili"), ColorModel(
                    R.drawable.torres3,"Dandy Mavi"), ColorModel(R.drawable.torres4,"Demir Grisi"), ColorModel(
                    R.drawable.torres5,"Uzay Siyahı"), ColorModel(R.drawable.torres6,"Kiraz Kırmızısı"), ColorModel(
                    R.drawable.torres7,"Platinum Gri"))
                gallery= listOf(
                    R.drawable.torres_gallery1,
                    R.drawable.torres_gallery2,
                    R.drawable.torres_gallery3,
                    R.drawable.torres_gallery4,
                    R.drawable.torres_gallery5,
                    R.drawable.torres_gallery6,
                    R.drawable.torres_gallery7,
                    R.drawable.torres_gallery8,
                    R.drawable.torres_gallery9,
                    R.drawable.torres_gallery10,
                    R.drawable.torres_gallery11,
                    R.drawable.torres_gallery12,
                    R.drawable.torres_gallery13,
                    R.drawable.torres_gallery14,
                    R.drawable.torres_gallery15,
                    R.drawable.torres_gallery16
                )
                videos = listOf(VideoModel("android.resource://" + packageName + "/" + R.raw.torres_video,
                    R.drawable.torres_video_cover
                ))

                binding.videoList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
                binding.videoList.adapter = VideoAdapter(videos)
                binding.galleryList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
                binding.galleryList.adapter = GalleryPicAdapter(gallery)
                binding.galleryTitle.setImageResource(R.drawable.torres_logo_color)
            }
            "Torres EVX" -> {
                images = listOf(
                    ColorModel(R.drawable.torres_evx1,"Dandy Blue"), ColorModel(R.drawable.torres_evx2,"Forest Green"), ColorModel(
                        R.drawable.torres_evx3,"Grand White"), ColorModel(R.drawable.torres_evx4,"Iron Metal"),
                    ColorModel(R.drawable.torres_evx5,"Latte Greige"), ColorModel(R.drawable.torres_evx6,"Platinum Gray"), ColorModel(
                        R.drawable.torres_evx7,"Space Black")
                )
                gallery= listOf(
                    R.drawable.torres_evx_gallery1,
                    R.drawable.torres_evx_gallery2,
                    R.drawable.torres_evx_gallery4,
                    R.drawable.torres_evx_gallery5,
                    R.drawable.torres_evx_gallery6,
                    R.drawable.torres_evx_gallery7,
                    R.drawable.torres_evx_gallery8,
                    R.drawable.torres_evx_gallery9,
                    R.drawable.torres_evx_gallery10,
                    R.drawable.torres_evx_gallery11,
                    R.drawable.torres_evx_gallery12,
                    R.drawable.torres_evx_gallery13
                )
                videos = listOf(
                    VideoModel("android.resource://" + packageName + "/" + R.raw.torres_evx_video,
                        R.drawable.torres_evx_video_cover
                    ),
                    VideoModel("android.resource://" + packageName + "/" + R.raw.torres_evx_video3,
                        R.drawable.torres_evx_video_cover3
                    ),
                    VideoModel("android.resource://" + packageName + "/" + R.raw.torres_evx_video4,
                        R.drawable.torres_evx_video_cover4
                    )
                )

                binding.videoList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
                binding.videoList.adapter = VideoAdapter(videos)
                binding.galleryList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
                binding.galleryList.adapter = GalleryPicAdapter(gallery)
                binding.galleryTitle.setImageResource(R.drawable.torres_evx_logo_color)
            }
            else -> {
                images = listOf(
                    ColorModel(R.drawable.musso_grand1,"Kiraz Kırmızısı"), ColorModel(R.drawable.musso_grand2,"Mermer Gri"), ColorModel(
                        R.drawable.musso_grand3,"Galaksi Gri"),
                    ColorModel(R.drawable.musso_grand4,"Siyah"), ColorModel(R.drawable.musso_grand5,"İnci Beyaz"),
                    ColorModel(R.drawable.musso_grand6,"Beyaz"), ColorModel(R.drawable.musso_grand7,"Amazon Yeşili"),
                    ColorModel(R.drawable.musso_grand8,"Kum Beji")
                )
                gallery= listOf(
                    R.drawable.musso_grand_gallery3,
                    R.drawable.musso_grand_gallery4,
                    R.drawable.musso_grand_gallery5,
                    R.drawable.musso_grand_gallery6,
                    R.drawable.musso_grand_gallery7,
                    R.drawable.musso_grand_gallery8,
                    R.drawable.musso_grand_gallery9,
                    R.drawable.musso_grand_gallery10,
                    R.drawable.musso_grand_gallery11,
                    R.drawable.musso_grand_gallery12,
                    R.drawable.musso_grand_gallery13,
                    R.drawable.musso_grand_gallery14,
                    R.drawable.musso_grand_gallery15,
                    R.drawable.musso_grand_gallery19
                )
                videos = listOf(VideoModel("android.resource://" + packageName + "/" + R.raw.musso_grand_video,
                    R.drawable.musso_grand_gallery10
                ))

                binding.videoList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
                binding.videoList.adapter = VideoAdapter(videos)
                binding.galleryList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
                binding.galleryList.adapter = GalleryPicAdapter(gallery)
                binding.galleryTitle.setImageResource(R.drawable.mussogrand_logo_color)

            }
        }
        binding.colorList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.colorList.adapter = ColorAdapter(images)
        binding.galleryPageLogo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}