package com.yakow.weber.myapplication.presenter.jokes

import androidx.paging.PagedList
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.yakow.weber.myapplication.entity.Joke

/**
 * Created on 26.02.19
 * @author YWeber */
@StateStrategyType(AddToEndSingleStrategy::class)
interface JokesView : MvpView {
    fun showProgress(visible: Boolean = true)
    fun bindJokes(jokesPagedList: PagedList<Joke>)
}