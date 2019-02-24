package com.yakow.weber.myapplication.toothpick.provider

import com.yakow.weber.myapplication.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created on 24.02.19
 * @author YWeber */

class OkHttpClientProvider @Inject constructor() : Provider<OkHttpClient> {
    companion object {
        private const val CONNECT_TIMEOUT = 30 * 1000L
        private const val READ_TIMEOUT = 30 * 1000L
    }

    override fun get(): OkHttpClient = with(OkHttpClient.Builder()) {
        connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
        readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
        if (BuildConfig.DEBUG) {
            addNetworkInterceptor(
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
            )
        }
        build()
    }
}