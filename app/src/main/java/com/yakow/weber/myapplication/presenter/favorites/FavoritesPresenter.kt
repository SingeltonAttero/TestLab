package com.yakow.weber.myapplication.presenter.favorites

import com.arellomobile.mvp.InjectViewState
import com.yakow.weber.myapplication.extension.printConstruction
import com.yakow.weber.myapplication.model.interactor.FavoritesInteractor
import com.yakow.weber.myapplication.presenter.base.BasePresenter
import com.yakow.weber.myapplication.toothpick.system.ResourceManager
import com.yakow.weber.myapplication.toothpick.system.message.SystemMessageNotifier
import timber.log.Timber
import javax.inject.Inject

/**
 * Created on 12.03.19
 * @author YWeber */
@InjectViewState
class FavoritesPresenter @Inject constructor(private val systemMessage: SystemMessageNotifier,
                                             private val resourceManager: ResourceManager,
                                             private val interactor: FavoritesInteractor) : BasePresenter<FavoritesView>() {
    init {
        printConstruction()
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        interactor.getAllFavorites()
                .subscribe({
                    viewState.bindFavorites(it)
                }, {
                    Timber.e(it, "error get all favorites")
                }).bind()
    }
}