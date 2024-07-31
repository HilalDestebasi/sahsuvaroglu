package com.sahsuvaroglu.kgm

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class CarPageActivity : AppCompatActivity() {
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

        setContentView(R.layout.activity_car_page)
        val carName = intent.getStringExtra("CAR_NAME")

        val sgLogo: ImageView = findViewById(R.id.car_page_sg_logo)
        sgLogo.setOnClickListener {
            showPopup(it, this)
        }

        val textView: ImageView = findViewById(R.id.car_page_title)
        val back: TextView = findViewById(R.id.car_page_back_icon)
        back.setOnClickListener {
            finish()
        }

        if(carName == "Torres"){
            textView.setImageResource(R.drawable.torres_logo_color)
        }else if(carName == "Torres EVX"){
            textView.setImageResource(R.drawable.torres_evx_logo_color)
        }else{
            textView.setImageResource(R.drawable.mussogrand_logo_color)
        }

        val backHome: ImageView = findViewById(R.id.car_page_logo)
        backHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        val priceList : LinearLayout = findViewById(R.id.price_list_container)
        priceList.setOnClickListener {
            val intent = Intent(this, PriceListActivity::class.java)
            intent.putExtra("CAR_NAME", carName)
            startActivity(intent)
        }


        val loc: LinearLayout = findViewById(R.id.location_container)
        loc.setOnClickListener {
            val intent = Intent(this, LocationActivity::class.java)
            startActivity(intent)
        }
        val th: LinearLayout = findViewById(R.id.hardware_n_technical_container)
        if(carName == "Torres EVX"){
            th.setOnClickListener {
                val intent = Intent(this, HardwareAndTechnicalPageActivity::class.java)
                intent.putExtra("CAR_NAME", carName)
                startActivity(intent)
            }
        }else{
            th.setOnClickListener{
                val intent = Intent(this, CarModelActivity::class.java)
                intent.putExtra("CAR_NAME", carName)
                startActivity(intent)
            }
        }
        val gallery: LinearLayout = findViewById(R.id.gallery_container)
        gallery.setOnClickListener {
            val intent = Intent(this, GalleryActivity::class.java)
            intent.putExtra("CAR_NAME", carName)
            startActivity(intent)
        }

    }



}