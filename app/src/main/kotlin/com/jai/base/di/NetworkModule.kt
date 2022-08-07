package com.jai.base.di

import android.content.Context
import com.jai.base.constant.AppConstant.BASE_URL
import com.jai.base.data.source.datastore.AppDataStore
import com.jai.base.data.source.network.NetworkCall
import com.jai.base.data.source.network.NetworkConnectionInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * Created by Jaydeep Khambhayta
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    internal fun provideNetworkConnectionInterceptor(
        mContext: Context,
        appDataStore: AppDataStore
    ): NetworkConnectionInterceptor {
        return NetworkConnectionInterceptor(mContext, appDataStore)
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(interceptor: NetworkConnectionInterceptor): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient().newBuilder()
                    .connectTimeout(40, TimeUnit.SECONDS)
                    .readTimeout(90, TimeUnit.SECONDS)
                    .writeTimeout(90, TimeUnit.SECONDS)
                    .addInterceptor(interceptor)
                    .retryOnConnectionFailure(true)
                    .build()
            )
            .build()
    }

    @Provides
    @Singleton
    internal fun provideNetworkApi(retrofit: Retrofit): NetworkCall {
        return retrofit.create(NetworkCall::class.java)
    }
}