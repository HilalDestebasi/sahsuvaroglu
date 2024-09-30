package com.sahsuvaroglu.kgm.presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.sahsuvaroglu.kgm.R
import com.sahsuvaroglu.kgm.util.showPopup

class FullScreenImageActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "ResourceAsColor")
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
        setContentView(R.layout.activity_full_screen_image)
        val imageView: ImageView = findViewById(R.id.full_screen_image_view)
        val imageResId = intent.getIntExtra("image_res_id", R.drawable.torres_gallery1)
        val model = intent.getStringExtra("image_style")
        val container: ConstraintLayout =findViewById(R.id.gallery_top_bar_container)
        val back: TextView = findViewById(R.id.full_screen_back)

        val backHome: ImageView = findViewById(R.id.full_screen_logo)
        backHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        if(model == "color"){
            container.setBackgroundResource(R.color.transparent)
            backHome.setImageResource(R.drawable.kgm_logo_w)
            back.setTextColor(R.color.main_color)
            back.setBackgroundResource(R.drawable.review)
        }
        imageView.setImageResource(imageResId)

        val sgLogo: ImageView = findViewById(R.id.full_screen_sg_logo)
        sgLogo.setOnClickListener {
            showPopup(it, this)
        }

        back.setOnClickListener {
            finish()
        }

    }
}