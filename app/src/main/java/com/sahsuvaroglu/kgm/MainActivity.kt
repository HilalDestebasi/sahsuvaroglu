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
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.firestore.FirebaseFirestore

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

// Assuming the root reference has a list of cars
        val carsRef = database.reference.child("cars")

        carsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (carSnapshot in snapshot.children) {
                        try {

                            val car = carSnapshot.getValue(Car::class.java)
                            car?.let {
                                Log.d(TAG, "Fetched car data: $it")
                                when (it.name) {
                                    "Musso Grand" -> CarManager.setMussoGrand(it)
                                    "Torres" -> CarManager.setTorres(it)
                                    "Torres EVX" -> CarManager.setTorresEvx(it)
                                }
                            }
                        } catch (e: Exception) {
                            Log.e(TAG, "Error parsing car data: ${e.message}")
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read car values.", error.toException())
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
