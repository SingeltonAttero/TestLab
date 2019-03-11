package com.yakow.weber.myapplication.presenter.jokes.detailed

import com.arellomobile.mvp.InjectViewState
import com.yakow.weber.myapplication.R
import com.yakow.weber.myapplication.entity.Joke
import com.yakow.weber.myapplication.extension.printConstruction
import com.yakow.weber.myapplication.extension.userMessage
import com.yakow.weber.myapplication.model.interactor.JokesInteractor
import com.yakow.weber.myapplication.presenter.base.BasePresenter
import com.yakow.weber.myapplication.toothpick.system.ResourceManager
import com.yakow.weber.myapplication.toothpick.system.message.SystemMessageNotifier
import timber.log.Timber
import javax.inject.Inject

/**
 * Created on 02.03.19
 * @author YWeber */
@InjectViewState
class DetailedJokePresenter @Inject constructor(
    private val interactor: JokesInteractor,
    private val systemMessage: SystemMessageNotifier,
    private val resourceManager: ResourceManager
) :
    BasePresenter<DetailedJokeView>() {
    init {
        printConstruction()
    }
    val joke: Joke
        get() = interactor.joke

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.bindJoke(interactor.joke)
    }

    fun saveJoke() {
        interactor.saveJoke()
            .subscribe({
                systemMessage.systemMessage(resourceManager.getString(R.string.save_history))
            }, {
                systemMessage.systemMessage(it.userMessage(resourceManager))
                Timber.e(it)
            }).bind()
    }

}