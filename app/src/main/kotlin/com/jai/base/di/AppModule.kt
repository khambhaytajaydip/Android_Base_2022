package com.jai.base.di

import android.app.Application
import android.content.Context
import com.jai.base.data.source.datastore.AppDataStore
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
class AppModule {
    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideAppPreference(context: Context): AppDataStore {
        return AppDataStore(context)
    }

    @Provides
    @Singleton
    internal fun provideMutableMap(): MutableMap<String, Any> {
        return mutableMapOf()
    }
}