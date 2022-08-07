package com.jai.base.di

import android.content.Context
import com.jai.base.data.DataManager
import com.jai.base.data.source.datastore.AppDataStore
import com.jai.base.data.source.network.NetworkCall
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Jaydeep Khambhayta
 */
@Module
@InstallIn(SingletonComponent::class)
class RepoModule {
    @Provides
    @Singleton
    internal fun provideRepository(
        neworkCall: NetworkCall,
        appPreferences: AppDataStore,
        map:MutableMap<String, Any>,
        context: Context,
    ): DataManager {
        return DataManager(neworkCall,appPreferences,map,context)
    }
}