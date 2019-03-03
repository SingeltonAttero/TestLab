package com.yakow.weber.myapplication.presenter.jokes.detailed

import com.arellomobile.mvp.InjectViewState
import com.yakow.weber.myapplication.extension.printConstruction
import com.yakow.weber.myapplication.model.interactor.JokesInteractor
import com.yakow.weber.myapplication.presenter.base.BasePresenter
import javax.inject.Inject

/**
 * Created on 02.03.19
 * @author YWeber */
@InjectViewState
class DetailedJokePresenter @Inject constructor(private val interactor: JokesInteractor) :
    BasePresenter<DetailedJokeView>() {
    init {
        printConstruction()
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.bindJoke(interactor.joke)
    }

}