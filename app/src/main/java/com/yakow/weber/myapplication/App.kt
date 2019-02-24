package com.yakow.weber.myapplication

import android.app.Application
import com.yakow.weber.myapplication.toothpick.DI
import com.yakow.weber.myapplication.toothpick.module.AppModule
import timber.log.Timber
import toothpick.Toothpick
import toothpick.configuration.Configuration
import toothpick.registries.FactoryRegistryLocator
import toothpick.registries.MemberInjectorRegistryLocator

/**
 * Created on 24.02.19
 * @author YWeber
 * project CodeTestLab */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initLogger()
        initToothpick()
        initScope()
    }

    private fun initScope() {
        Toothpick.openScope(DI.APP_SCOPE).installModules(AppModule(this))
    }

    private fun initToothpick() {
        if (BuildConfig.DEBUG) {
            Toothpick.setConfiguration(Configuration.forDevelopment().preventMultipleRootScopes())
        } else {
            Toothpick.setConfiguration(Configuration.forProduction().disableReflection())
            FactoryRegistryLocator.setRootRegistry(com.yakow.weber.myapplication.FactoryRegistry())
            MemberInjectorRegistryLocator.setRootRegistry(com.yakow.weber.myapplication.MemberInjectorRegistry())
        }
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}