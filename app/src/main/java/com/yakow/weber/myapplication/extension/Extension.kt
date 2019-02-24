package com.yakow.weber.myapplication.extension

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import timber.log.Timber

/**
 * Created on 15.02.19
 * @author YWeber */

fun ViewGroup.inflate(@LayoutRes layoutId: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)

fun <T> T.printDebug(message: String = "Error"): T =
    this.also { Timber.e("$message...$this") }

inline fun <reified T> T.printConstruction() =
    Timber.e("Constructing...${T::class.java.simpleName}")