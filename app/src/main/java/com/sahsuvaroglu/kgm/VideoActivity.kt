package com.sahsuvaroglu.kgm

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VideoActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
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
        setContentView(R.layout.activity_video)


        val videoView: VideoView = findViewById(R.id.video_view)

        val sgLogo: ImageView = findViewById(R.id.video_sg_logo)
        sgLogo.setOnClickListener {
            showPopup(it, this)
        }

        val back: TextView = findViewById(R.id.video_back)
        back.setOnClickListener {
            finish()
        }
        val backHome: ImageView = findViewById(R.id.video_logo)
        backHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val videoPath = intent.getStringExtra("video_url")
        val uri = Uri.parse(videoPath)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        videoView.setVideoURI(uri)
        videoView.setMediaController(mediaController)

        videoView.start()
    }
}