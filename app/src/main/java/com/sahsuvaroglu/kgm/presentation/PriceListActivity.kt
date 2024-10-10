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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sahsuvaroglu.kgm.util.CarManager
import com.sahsuvaroglu.kgm.R
import com.sahsuvaroglu.kgm.adapter.CarPriceAdapter
import com.sahsuvaroglu.kgm.util.showPopup
import com.sahsuvaroglu.kgm.util.showPopupKampanya

class PriceListActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
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

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_price_list)

        val textView: TextView = findViewById(R.id.price_list_car_name)
        val title: ImageView = findViewById(R.id.price_list_title)
        val backHome: ImageView = findViewById(R.id.price_list_page_logo)
        backHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val img: ImageView = findViewById(R.id.price_list_car_img)

        val kampanya: TextView = findViewById(R.id.kampanya_button)

        val sgLogo: ImageView = findViewById(R.id.price_list_sg_logo)
        sgLogo.setOnClickListener {
            showPopup(it, this)
        }
        kampanya.visibility = View.GONE
        if(carName=="Torres"){
            val recycler_view: RecyclerView = findViewById(R.id.price_list)
            recycler_view.layoutManager = LinearLayoutManager(this)
            recycler_view.adapter = CarPriceAdapter(CarManager.getTorres().priceList)
            img.setImageResource(R.drawable.torres3)
            textView.text = "TORRES"
            title.setImageResource(R.drawable.torres_logo_color)
        }else if(carName == "Torres EVX"){
            val recycler_view: RecyclerView = findViewById(R.id.price_list)
            recycler_view.layoutManager = LinearLayoutManager(this)
            recycler_view.adapter = CarPriceAdapter(CarManager.getTorresEvx().priceList)
            img.setImageResource(R.drawable.torres_evx)
            textView.text = "Torres EVX"
            title.setImageResource(R.drawable.torres_evx_logo_color)
        }else{
            val recycler_view: RecyclerView = findViewById(R.id.price_list)
            recycler_view.layoutManager = LinearLayoutManager(this)
            recycler_view.adapter = CarPriceAdapter(CarManager.getMussoGrand().priceList)
            img.setImageResource(R.drawable.musso_grand)
            textView.text = "MUSSO GRAND"
            title.setImageResource(R.drawable.mussogrand_logo_color)
        }

        val back: TextView = findViewById(R.id.price_list_back_icon)
        back.setOnClickListener {
            finish()
        }

    }

}