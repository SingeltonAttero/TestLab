package com.yakow.weber.myapplication.presenter

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created on 24.02.19
 * @author YWeber */
interface MainView : MvpView {
    @StateStrategyType(SkipStrategy::class)
    fun showToastError(message: String)
}