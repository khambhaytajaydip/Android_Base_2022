package com.jai.base.data.source.datastore
import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.jai.base.constant.AppConstant.DATA_STORE_USER_ID
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Jaydeep Khambhayta
 */
val Context.appDataStore by preferencesDataStore("test_datastore")
@Singleton
class AppDataStore @Inject constructor(val context: Context) {
    private val preferences = context.appDataStore.data
    // get data store methods

    suspend fun getUserId(): Int {
        return preferences.first()[DATA_STORE_USER_ID] ?: 0
    }

    suspend fun setUserId(id: Int) {
        context.appDataStore.edit { preferences ->
            preferences[DATA_STORE_USER_ID] = id
        }
    }
}