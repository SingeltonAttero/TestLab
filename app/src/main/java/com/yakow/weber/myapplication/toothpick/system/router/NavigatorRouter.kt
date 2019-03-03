package com.yakow.weber.myapplication.toothpick.system.router

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavOptions

/**
 * Created on 28.02.19
 * @author YWeber */
class NavigatorRouter(private val navigator: NavController) : RouterProvider {
    override fun startFlow(idView: Int, bundle: Bundle?) {
        navigator.navigate(idView, bundle)
    }

    override fun newRootFlow(newRootIdFragment: Int, oldRootIdFragment: Int, bundle: Bundle?) {
        val options = NavOptions.Builder()
            .setPopUpTo(oldRootIdFragment, true)
            .setLaunchSingleTop(true)
            .build()
        navigator.navigate(newRootIdFragment, bundle, options)
    }

    override fun back() {
        navigator.popBackStack()
    }
}