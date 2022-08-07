package com.jai.base.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import android.view.*
import android.widget.ImageView
import com.jai.base.R
import com.bumptech.glide.Glide

/**
 * Created by Jaydeep Khambhayta
 */
object AppUtils {
    fun showLoadingDialog(context: Context): Dialog {
        val dialog = Dialog(context, R.style.Dialog)
        val inflate = LayoutInflater.from(context)
            .inflate(R.layout.progress_dialog, null)
        dialog.setContentView(inflate)
//        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawable(
            ColorDrawable(Color.TRANSPARENT)
        )

        dialog.window?.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            statusBarColor = Color.TRANSPARENT
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                setDecorFitsSystemWindows(false)
                insetsController?.apply {
//                    hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                    systemBarsBehavior =
                        WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                }
            } else {
                @Suppress("DEPRECATION")
                decorView.systemUiVisibility = (
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
            }
        }
        dialog.show()
        return dialog
    }


    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        if (cm != null) {
            val network: Network = cm.activeNetwork ?: return false
            val capabilities: NetworkCapabilities? =
                cm.getNetworkCapabilities(network) ?: return false
            return capabilities != null && (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                    || capabilities.hasTransport(
                NetworkCapabilities.TRANSPORT_CELLULAR
            ))
        }
        return false
    }

}