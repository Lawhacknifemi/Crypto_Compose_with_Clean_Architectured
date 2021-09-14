package com.sherif.cryptocompose

import android.app.Application
import com.sherif.cryptocompose.common.Logger
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()
     initLogger()
    }
    private fun initLogger() {
        Logger.init()
    }
}