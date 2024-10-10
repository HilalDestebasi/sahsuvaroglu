package com.sahsuvaroglu.kgm.presentation

import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.sahsuvaroglu.kgm.R

class MainActivity : AppCompatActivity() {
    //Activity
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

        setContentView(R.layout.activity_main)
        val torresEvxImageView: ImageView = findViewById(R.id.torres_evx_main_page_img)
        val torresImageView: ImageView = findViewById(R.id.torres_main_page_img)
        val mussoGrandImageView: ImageView = findViewById(R.id.musso_grand_main_page_img)

        torresEvxImageView.setOnClickListener {
            openCarPageActivity("Torres EVX")
        }

        torresImageView.setOnClickListener {
            openCarPageActivity("Torres")
        }

        mussoGrandImageView.setOnClickListener {
            openCarPageActivity("Musso Grand")
        }
    }

    private fun openCarPageActivity(carName: String) {
        val intent = Intent(this, CarPageActivity::class.java)
        intent.putExtra("CAR_NAME", carName)
        startActivity(intent)
    }

}