package com.jai.base.constant

import androidx.datastore.preferences.core.intPreferencesKey

/**
 * Created by Jaydeep Khambhayta
 */
object AppConstant {

    // Network cons
    val BASE_URL by lazy { "https://test.com/" }




    // Datastore Keys
    val DATA_STORE_USER_ID by lazy { intPreferencesKey("DATA_STORE_USER_ID") }

}