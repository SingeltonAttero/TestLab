package com.yakow.weber.myapplication.toothpick.system.disposable

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created on 05.02.19
 * @author YWeber */

interface ComponentDisposablesProvider {
    val compositeDisposable: CompositeDisposable
    fun clear()
    fun Disposable.bind()
}