package com.jai.base

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Jaydeep Khambhayta
 */
@HiltAndroidApp
class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        //disable dark mode
        AppCompatDelegate
            .setDefaultNightMode(
                AppCompatDelegate
                    .MODE_NIGHT_NO
            )
    }
}