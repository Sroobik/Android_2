package com.example.android_2

import android.app.Application
import com.facebook.stetho.Stetho

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)
    }
}