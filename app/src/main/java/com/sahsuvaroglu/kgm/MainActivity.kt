package com.sahsuvaroglu.kgm

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

   // private lateinit var db: FirebaseFirestore

    //Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.activity_main)
        enableEdgeToEdge()

        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }

        val database = FirebaseDatabase.getInstance()

        val carsRef = database.reference.child("cars")

        carsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                        for (carSnapshot in snapshot.children) {
                            try {
                                val firebaseCar = carSnapshot.getValue(FirebaseCar::class.java)
                                firebaseCar?.let {
                                    val car = it.toCar()
                                    Log.d(TAG, "Fetched car data: $car")
                                    when (carSnapshot.key) {
                                        "Musso Grand" -> CarManager.setMussoGrand(car)
                                        "Torres" -> CarManager.setTorres(car)
                                        "Torres EVX" -> CarManager.setTorresEvx(car)
                                        else -> Log.d(TAG, "Unknown car model: ${carSnapshot.key}")
                                    }
                                }
                            } catch (e: Exception) {
                                Log.e(TAG, "Error parsing car data: ${e.message}")
                            }
                        }
                } else {
                    Log.d(TAG, "No data exists at this reference.")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(TAG, "Database error: ${error.message}")
            }
        })




    }
    private fun openCarPageActivity(carName: String) {
        val intent = Intent(this, CarPageActivity::class.java)
        intent.putExtra("CAR_NAME", carName)
        startActivity(intent)
    }

    private fun enableEdgeToEdge() {
        setupImageViewClickListeners()
    }

    private fun setupImageViewClickListeners() {
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
}
