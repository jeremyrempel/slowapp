package com.example.slowapp

import android.app.Application

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initDelay()
    }

    private fun initDelay() {

        // do the really long thing
        Thread.sleep(2000)
    }
}