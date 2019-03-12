package com.yakow.weber.myapplication.presenter.favorites

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.yakow.weber.myapplication.entity.Favorites

/**
 * Created on 12.03.19
 * @author YWeber */
@StateStrategyType(AddToEndSingleStrategy::class)
interface FavoritesView : MvpView{
    fun bindFavorites(favoritesList: List<Favorites>)
}