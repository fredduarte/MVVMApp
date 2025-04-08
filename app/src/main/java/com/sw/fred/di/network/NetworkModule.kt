package com.sw.fred.di.network

import android.content.Context
import com.sw.fred.BuildConfig
import com.sw.fred.data.network.MealDbApi
import com.sw.fred.data.network.Network
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideMealDbApi(
        okHttpClient: OkHttpClient,
    ): MealDbApi = Network.createService(
        "${BuildConfig.THE_MEAL_DB_API_URL}/${BuildConfig.THE_MEAL_DB_API_KEY}/",
        okHttpClient,
        MealDbApi::class.java
    )

    // Provides an instance of OkHttpClient for network operations
    @Provides
    @Singleton
    fun provideOkHttpClient(
        @ApplicationContext context: Context,
    ) : OkHttpClient {
        return Network.createOkHttpClient(context.cacheDir)
    }
}
