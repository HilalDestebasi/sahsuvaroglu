    package com.sahsuvaroglu.kgm

    import android.app.Application
    import com.google.firebase.FirebaseApp

    class SahsuvarogluApplication:Application() {
        override fun onCreate() {
            super.onCreate()
            FirebaseApp.initializeApp(this)
        }
    }