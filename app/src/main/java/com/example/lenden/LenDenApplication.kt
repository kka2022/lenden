package com.example.lenden

import android.app.Application
import com.example.lenden.data.AppContainer
import com.example.lenden.data.AppDataContainer

class LenDenApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}