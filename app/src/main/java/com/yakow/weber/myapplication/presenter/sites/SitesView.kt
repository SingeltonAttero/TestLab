package com.yakow.weber.myapplication.presenter.sites

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.yakow.weber.myapplication.entity.JokeSites

/**
 * Created on 24.02.19
 * @author YWeber */
@StateStrategyType(AddToEndSingleStrategy::class)
interface SitesView : MvpView {
    fun siteList(sites: List<JokeSites>)
    fun showProgress(visible: Boolean = true)
}