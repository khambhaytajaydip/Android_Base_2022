package com.jai.base.data

import android.content.Context
import com.jai.base.data.source.datastore.AppDataStore
import com.jai.base.data.source.network.NetworkCall
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Jaydeep Khambhayta
 */
@Singleton
class DataManager @Inject constructor(
    val networkCall: NetworkCall,
    val appDataStore: AppDataStore,
    val map: MutableMap<String, Any>,
    val context: Context
) {
}