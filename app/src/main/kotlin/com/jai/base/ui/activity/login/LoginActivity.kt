package com.jai.base.ui.activity.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.jai.base.R
import com.jai.base.databinding.ActivityLoginBinding
import com.jai.base.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.jai.base.ui.activity.main.MainActivity
import com.jai.base.utils.AppCoroutines
import kotlinx.coroutines.delay

/**
 * Created by Jaydeep Khambhayta
 */
@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    @Inject
    lateinit var loginViewModel: LoginViewModel
    override fun getLayoutId() = R.layout.activity_login
    override fun getViewModel() = loginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var newData = 0
        Log.d("jai", "11")
        AppCoroutines.main {
            delay(5000)
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
            viewBinding()
        }
        Log.d("jai", "33")
        showLoading()
    }
}