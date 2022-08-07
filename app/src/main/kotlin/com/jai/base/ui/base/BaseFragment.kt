package com.jai.base.ui.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.jai.base.R

/**
 * Created by Jaydeep Khambhayta
 */
abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> : Fragment() {
    var mActivity: BaseActivity<T, V>? = null
    lateinit var mViewDataBinding: T
    lateinit var mViewModel: V
    abstract fun getLayoutId(): Int
    abstract fun getViewModel(): V
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*, *>) {
            mActivity = context as BaseActivity<T, V>?
        }
    }

    override fun onDetach() {
        mActivity = null
        super.onDetach()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = getViewModel()
//        setHasOptionsMenu(false)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return mViewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getView()?.let { ViewCompat.setTranslationZ(it, 1000f) }
        mViewDataBinding.lifecycleOwner = this
        mViewDataBinding.executePendingBindings()
    }

    fun isNetworkConnected(): Boolean = mActivity != null && mActivity!!.isNetworkConnected()
    fun getBaseActivity(): BaseActivity<T, V>? = mActivity
    fun showMessage(message: String) {
        mActivity?.showMessage(message)
    }

    override fun onDestroy() {
        if (::mViewDataBinding.isInitialized)
            mViewDataBinding.unbind()
        super.onDestroy()
    }

    override fun onDestroyView() {
        mViewDataBinding.unbind()
        super.onDestroyView()
    }

    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
        mActivity!!.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)

    }

    fun startActivityUp(intent: Intent?) {
        super.startActivity(intent)
        mActivity!!.overridePendingTransition(R.anim.slide_in_up, R.anim.no_animation)
    }

    interface Callback {
        fun onFragmentDetached(tag: String)
    }
}