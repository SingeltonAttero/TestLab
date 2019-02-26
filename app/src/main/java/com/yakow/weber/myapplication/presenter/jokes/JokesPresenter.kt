package com.yakow.weber.myapplication.presenter.jokes

import com.arellomobile.mvp.InjectViewState
import com.yakow.weber.myapplication.extension.userMessage
import com.yakow.weber.myapplication.model.interactor.JokesInteractor
import com.yakow.weber.myapplication.presenter.base.BasePresenter
import com.yakow.weber.myapplication.toothpick.system.ResourceManager
import com.yakow.weber.myapplication.toothpick.system.message.SystemMessageNotifier
import timber.log.Timber
import javax.inject.Inject

/**
 * Created on 26.02.19
 * @author YWeber */
@InjectViewState
class JokesPresenter @Inject constructor(
    private val systemMessage: SystemMessageNotifier,
    private val interactor: JokesInteractor,
    private val resourceManager: ResourceManager
) :
    BasePresenter<JokesView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        interactor.getJokes()
            .doOnSubscribe { viewState.showProgress(true) }
            .doAfterTerminate { viewState.showProgress(false) }
            .subscribe({
                viewState.bindJokes(it)
            }, {
                systemMessage.systemMessage(it.userMessage(resourceManager))
                Timber.e(it)
            }).bind()
    }

}