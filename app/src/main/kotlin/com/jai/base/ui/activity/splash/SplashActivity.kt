package com.jai.base.ui.activity.splash

import android.content.Intent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jai.base.ui.activity.login.LoginActivity
import com.jai.base.utils.AppCoroutines
import kotlinx.coroutines.delay

/**
 * Created by Jaydeep Khambhayta
 */
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition { true }
        AppCoroutines.main {
            delay(2000)
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()
        }
    }
}