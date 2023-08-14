package com.myapplication

import android.app.Application
import di.initializeKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level.DEBUG
import org.koin.core.logger.Level.NONE

class CharacterApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKoin {
            androidContext(this@CharacterApp)
            androidLogger(if (BuildConfig.DEBUG) DEBUG else NONE)
        }
    }
}