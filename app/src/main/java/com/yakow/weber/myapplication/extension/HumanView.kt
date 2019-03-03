package com.yakow.weber.myapplication.extension

import android.os.Build
import android.text.Html
import android.text.Spanned
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import com.yakow.weber.myapplication.R
import com.yakow.weber.myapplication.toothpick.system.ResourceManager
import java.io.IOException

/**
 * Created on 25.02.19
 * @author YWeber */
fun String.toSpanned(): Spanned {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
    } else {
        @Suppress("DEPRECATION")
        return Html.fromHtml(this)
    }
}

fun Throwable.userMessage(resourceManager: ResourceManager): String = when (this) {
    is HttpException -> when (code()) {
        400 -> resourceManager.getString(R.string.bad_request_error)
        404 -> resourceManager.getString(R.string.not_found_error)
        500 -> resourceManager.getString(R.string.server_error_error)
        else -> resourceManager.getString(R.string.unknown_error)
    }
    is IOException -> resourceManager.getString(R.string.network_error)
    else -> resourceManager.getString(R.string.unknown_error)
}