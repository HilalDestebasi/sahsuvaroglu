    package com.sahsuvaroglu.kgm

    import android.app.Application
    import android.net.ConnectivityManager
    import android.net.NetworkCapabilities
    import android.util.Log
    import com.google.firebase.FirebaseApp
    import com.google.firebase.database.DataSnapshot
    import com.google.firebase.database.DatabaseError
    import com.google.firebase.database.FirebaseDatabase
    import com.google.firebase.database.ValueEventListener

    class SahsuvarogluApplication : Application() {
        override fun onCreate() {
            super.onCreate()
            FirebaseApp.initializeApp(this)


            if (checkInternetConnection()) {
                val database = FirebaseDatabase.getInstance()


                val carsRef = database.getReference("cars")

                carsRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for (carSnapshot in dataSnapshot.children) {
                            val carName = carSnapshot.key
                            val carDetails = carSnapshot.value
                            Log.d("FirebaseCar", "Car: $carName, Details: $carDetails")
                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        Log.w("FirebaseCar", "loadPost:onCancelled", databaseError.toException())
                    }
                })
            } else {
                Log.d("FirebaseCar", "Internet Connection failed")
            }
        }

        fun checkInternetConnection(): Boolean {
            val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            val network = connectivityManager.activeNetwork ?: return false
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }
    }