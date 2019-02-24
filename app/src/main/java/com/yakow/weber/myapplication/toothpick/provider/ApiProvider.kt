package com.yakow.weber.myapplication.toothpick.provider

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.yakow.weber.myapplication.model.data.server.Api
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created on 24.02.19
 * @author YWeber */

class ApiProvider @Inject constructor(
    private val httpClient: OkHttpClient,
    private val serverPath: String
) : Provider<Api> {
    override fun get(): Api = with(Retrofit.Builder()) {
        Timber.d("Creating api")
        addConverterFactory(GsonConverterFactory.create())
        addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        callbackExecutor(Executors.newFixedThreadPool(3))
        client(httpClient)
        baseUrl(serverPath)
        build()
    }.create(Api::class.java)
}