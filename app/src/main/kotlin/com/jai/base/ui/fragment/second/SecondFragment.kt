package com.jai.base.ui.fragment.second

import com.jai.base.R
import com.jai.base.databinding.FragmentSecondBinding
import com.jai.base.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Created by Jaydeep Khambhayta
 */
@AndroidEntryPoint
class SecondFragment : BaseFragment<FragmentSecondBinding, SecondViewModel>() {
    @Inject
    lateinit var secondViewModel: SecondViewModel
    override fun getLayoutId() = R.layout.fragment_second

    override fun getViewModel() = secondViewModel
}