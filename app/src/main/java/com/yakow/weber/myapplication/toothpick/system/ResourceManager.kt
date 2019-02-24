package com.yakow.weber.myapplication.toothpick.system

import android.content.Context
import androidx.annotation.StringRes
import java.io.InputStream
import javax.inject.Inject

/**
 * Created on 05.02.19
 * @author YWeber */

class ResourceManager @Inject constructor(private val context: Context) {

    fun getString(@StringRes resId: Int): String = context.resources.getString(resId)

    fun getString(@StringRes resId: Int, vararg formatArgs: Any?): String =
        context.resources.getString(resId, *formatArgs)

    fun getAsset(name: String): InputStream = context.resources.assets.open(name)
}