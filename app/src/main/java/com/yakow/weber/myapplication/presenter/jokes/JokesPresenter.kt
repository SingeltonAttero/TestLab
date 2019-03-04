package com.yakow.weber.myapplication.presenter.jokes

import com.arellomobile.mvp.InjectViewState
import com.yakow.weber.myapplication.R
import com.yakow.weber.myapplication.entity.Joke
import com.yakow.weber.myapplication.extension.userMessage
import com.yakow.weber.myapplication.model.interactor.JokesInteractor
import com.yakow.weber.myapplication.presenter.base.BasePresenter
import com.yakow.weber.myapplication.toothpick.system.ResourceManager
import com.yakow.weber.myapplication.toothpick.system.executor.ExecutorsProvider
import com.yakow.weber.myapplication.toothpick.system.message.SystemMessageNotifier
import com.yakow.weber.myapplication.toothpick.system.network.state.NetworkState
import com.yakow.weber.myapplication.toothpick.system.router.RouterProvider
import com.yakow.weber.myapplication.ui.jokes.adapter.JokesDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Created on 26.02.19
 * @author YWeber */
@InjectViewState
class JokesPresenter @Inject constructor(
        private val interactor: JokesInteractor,
        private val resourceManager: ResourceManager,
        private val systemMessage: SystemMessageNotifier,
        private val executors: ExecutorsProvider
) : BasePresenter<JokesView>() {

    private lateinit var jokesDataSource: JokesDataSource

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        Timber.e("test test")
        loadJokes()
    }

    fun loadJokes() {
        jokesDataSource = JokesDataSource(compositeDisposable, executors) { num: Int -> interactor.getJokes(num) }
        viewState.bindJokes(jokesPagedList = jokesDataSource.getPagedList())
        bindNetworkState()
    }

    private fun bindNetworkState() {
        jokesDataSource.stateNotifier
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showProgress() }
                .doAfterTerminate { viewState.showProgress(false) }
                .subscribe({
                    when (it) {
                        is NetworkState.Loading -> viewState.showProgress(true)
                        is NetworkState.Loaded -> viewState.showProgress(false)
                    }
                }, {
                    systemMessage.systemMessage(it.userMessage(resourceManager))
                }).bind()
    }

    fun goToDetailed(joke:Joke,router: RouterProvider){
        interactor.joke = joke
        router.startFlow(R.id.actionMenuFragmentToDetailedJokeFragment)
    }
}