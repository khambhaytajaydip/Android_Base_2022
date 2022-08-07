package com.jai.base.ui.base

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.jai.base.data.source.datastore.AppDataStore
import com.jai.base.utils.AppUtils
import com.jai.base.utils.AppUtils.showLoadingDialog
import javax.inject.Inject

/**
 * Created by Jaydeep Khambhayta
 */
abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity(),
    BaseFragment.Callback {
    private lateinit var mViewDataBinding: T
    fun viewBinding(): T = mViewDataBinding
    abstract fun getLayoutId(): Int
    private var mViewModel: V? = null
    abstract fun getViewModel(): V
    private var mProgressDialog: Dialog? = null

    @Inject
    lateinit var appDataStore: AppDataStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        perfomDataBinding()
    }


    override fun onFragmentDetached(tag: String) {
        mViewDataBinding.unbind()
    }

    private fun perfomDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        this.mViewModel = if (mViewModel == null) getViewModel() else mViewModel
        mViewDataBinding.executePendingBindings()
    }

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun showKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm?.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog?.isShowing!!) {
            mProgressDialog?.cancel()
        }
    }

    fun showLoading() {
        if (isNetworkConnected()) {
            hideLoading()
            mProgressDialog = showLoadingDialog(this)
        } else {
//            redSnackBar()
        }
    }

    fun getProgressDialog(): Dialog? {
        return if (mProgressDialog != null) {
            mProgressDialog
        } else {
            mProgressDialog = showLoadingDialog(this)
            hideLoading()
            mProgressDialog
        }
    }

    override fun onDestroy() {
        // clear all objects
        mViewModel = null
        hideLoading()
        super.onDestroy()
    }

    fun isNetworkConnected(): Boolean {
        return AppUtils.isNetworkConnected(applicationContext)
    }

    fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
//        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
    }

    fun startActivityUp(intent: Intent?) {
        super.startActivity(intent)
//        overridePendingTransition(R.anim.slide_in_up, R.anim.no_animation)
    }
}