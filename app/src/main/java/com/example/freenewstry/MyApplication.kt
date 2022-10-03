package com.example.freenewstry

import android.app.Application
import com.example.freenewstry.adapters.AdapterRest

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AdapterRest.init()
    }

}