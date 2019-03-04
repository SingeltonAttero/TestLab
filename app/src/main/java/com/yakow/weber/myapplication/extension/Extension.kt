package com.yakow.weber.myapplication.extension

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CheckResult
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.jakewharton.rxbinding2.view.RxView
import com.yakow.weber.myapplication.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import timber.log.Timber
import java.util.concurrent.TimeUnit

/**
 * Created on 15.02.19
 * @author YWeber */

@CheckResult
fun View.rxOnClickListener(onClick: () -> Unit) =
        RxView.clicks(this)
                .throttleFirst(300L, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy({ onClick() })

fun <T> Observable<T>.subscribeBy(
        onNext: (T) -> Unit,
        onError: (Throwable) -> Unit = { Timber.e(it) }
): Disposable = subscribe(onNext, onError)


fun ViewGroup.inflate(@LayoutRes layoutId: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)

fun <T> T.printDebug(message: String = "Error"): T =
    this.also { Timber.e("$message...$this") }

inline fun <reified T> T.printConstruction() =
    Timber.e("Constructing...${T::class.java.simpleName}")