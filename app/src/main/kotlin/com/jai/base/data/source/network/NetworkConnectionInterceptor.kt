package com.jai.base.data.source.network

import android.content.Context
import com.jai.base.data.source.datastore.AppDataStore
import com.jai.base.utils.AppCoroutines
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Jaydeep Khambhayta
 */
@Singleton
class NetworkConnectionInterceptor @Inject constructor(
    private val mContext: Context,
    private val dataStore: AppDataStore
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var toke = ""
        AppCoroutines.blocking {
            toke = dataStore.getUserId().toString()
        }
        val builder = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer " + toke)
            .build()
        return chain.proceed(builder)
    }
}

