package com.jai.base.ui.activity.main

import com.jai.base.R
import com.jai.base.databinding.ActivityMainBinding
import com.jai.base.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Created by Jaydeep Khambhayta
 */
@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModel(): MainViewModel = mainViewModel
}