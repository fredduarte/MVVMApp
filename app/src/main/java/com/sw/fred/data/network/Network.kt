package com.sw.fred.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sw.fred.BuildConfig
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.io.File
import java.util.concurrent.TimeUnit

object Network {

    private const val NETWORK_CALL_TIMEOUT = 30
    private const val CACHE_DIR_SIZE = 50L * 1024 * 1024 // 50 MB

    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    fun <T> createService(
        baseUrl: String,
        client: OkHttpClient,
        service: Class<T>,
    ): T {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(service)
    }

    fun createOkHttpClient(
        cacheDir: File,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .cache(Cache(cacheDir, CACHE_DIR_SIZE))
            .addInterceptor(getHttpLoggingInterceptor())
            .readTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .build()
    }

    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            }
    }
}