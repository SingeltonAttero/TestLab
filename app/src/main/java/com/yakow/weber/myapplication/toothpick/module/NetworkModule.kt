package com.yakow.weber.myapplication.toothpick.module

import com.yakow.weber.myapplication.model.data.server.Api
import com.yakow.weber.myapplication.toothpick.provider.ApiProvider
import com.yakow.weber.myapplication.toothpick.provider.OkHttpClientProvider
import com.yakow.weber.myapplication.toothpick.qualifier.ServerPath
import okhttp3.OkHttpClient
import timber.log.Timber
import toothpick.config.Module

/**
 * Created on 24.02.19
 * @author YWeber */

class NetworkModule(serverUrl: String) : Module() {
    init {
        Timber.d("Creating network module")
        bind(String::class.java).withName(ServerPath::class.java).toInstance(serverUrl)
        bind(OkHttpClient::class.java).toProvider(OkHttpClientProvider::class.java).providesSingletonInScope()
        bind(Api::class.java).toProvider(ApiProvider::class.java).providesSingletonInScope()
    }
}