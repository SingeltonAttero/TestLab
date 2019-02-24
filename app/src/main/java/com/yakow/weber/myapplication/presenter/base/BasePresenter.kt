package com.yakow.weber.myapplication.presenter.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.yakow.weber.myapplication.toothpick.system.disposable.ComponentDisposables
import com.yakow.weber.myapplication.toothpick.system.disposable.ComponentDisposablesProvider

/**
 * Created on 05.02.19
 * @author YWeber */
@StateStrategyType(SingleStateStrategy::class)
open class BasePresenter<V : MvpView> : MvpPresenter<V>(), ComponentDisposablesProvider by ComponentDisposables() {
    override fun onDestroy() {
        clear()
        super.onDestroy()
    }
}