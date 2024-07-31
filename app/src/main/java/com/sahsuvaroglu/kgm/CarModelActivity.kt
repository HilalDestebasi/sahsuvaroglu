package com.sahsuvaroglu.kgm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sahsuvaroglu.kgm.databinding.ActivityCarModelBinding
import com.sahsuvaroglu.kgm.databinding.ActivityHardwareAndTechnicalPageBinding

class CarModelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCarModelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.apply {
            systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityCarModelBinding.inflate(layoutInflater)
        binding.carModelSgLogo.setOnClickListener {
                showPopup(it, this)
        }
        enableEdgeToEdge()
        setContentView(binding.root)
        val carName = intent.getStringExtra("CAR_NAME")
        if(carName == "Torres"){
            binding.carModelList.layoutManager = GridLayoutManager(binding.root.context,2)
            binding.carModelList.adapter = CarModelAdapter(listOf(
                CarModel("Torres 4x2","Otomatik","Benzinli","4x2","₺2.471.450'den başlayan fiyatlarla",R.drawable.torres3),
                CarModel("Torres 4x4","Otomatik","Benzinli","4x4","₺2.671.450'den başlayan fiyatlarla",R.drawable.torres2),
            ))
            binding.carModelTitle.setImageResource(R.drawable.torres_logo_color)
        }else{
            binding.carModelList.layoutManager = GridLayoutManager(binding.root.context,2)
            binding.carModelList.adapter = CarModelAdapter(listOf(
                CarModel("Platinum D2.2 4x2","Otomatik","Dizel","4x2","₺1.401.365'den başlayan fiyatlarla",R.drawable.musso_grand4),
                CarModel("Platinum D2.2 4x4","Otomatik","Dizel","4x4","₺1.539.412'den başlayan fiyatlarla",R.drawable.musso_grand8),
                CarModel("Platinum Plus D2.2 4x2","Otomatik","Dizel","4x2","₺1.566.365'den başlayan fiyatlarla",R.drawable.musso_grand4),
                CarModel("Platinum Plus D2.2 4x4","Otomatik","Dizel","4x4","₺1.674.412'den başlayan fiyatlarla",R.drawable.musso_grand8),
            ))
            binding.carModelTitle.setImageResource(R.drawable.mussogrand_logo_color)
        }
        binding.carModelBackIcon.setOnClickListener {
            finish()
        }
        binding.carModelPageLogo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}