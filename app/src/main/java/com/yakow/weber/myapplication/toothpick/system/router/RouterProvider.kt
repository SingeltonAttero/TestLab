package com.yakow.weber.myapplication.toothpick.system.router

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.IntegerRes

/**
 * Created on 28.02.19
 * @author YWeber */

interface RouterProvider {
    fun startFlow(@IdRes idView:Int)
    fun newRootFlow(@IdRes newRootIdFragment: Int, @IdRes oldRootIdFragment:Int, bundle: Bundle? = null)
    fun back()
}