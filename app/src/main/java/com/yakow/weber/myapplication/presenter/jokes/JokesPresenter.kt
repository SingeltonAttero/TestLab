package com.yakow.weber.myapplication.presenter.jokes

import com.arellomobile.mvp.InjectViewState
import com.yakow.weber.myapplication.R
import com.yakow.weber.myapplication.entity.Joke
import com.yakow.weber.myapplication.model.interactor.JokesInteractor
import com.yakow.weber.myapplication.presenter.base.BasePresenter
import com.yakow.weber.myapplication.toothpick.system.executor.ExecutorsProvider
import com.yakow.weber.myapplication.toothpick.system.router.RouterProvider
import com.yakow.weber.myapplication.ui.jokes.adapter.JokesDataSource
import timber.log.Timber
import javax.inject.Inject

/**
 * Created on 26.02.19
 * @author YWeber */
@InjectViewState
class JokesPresenter @Inject constructor(
    private val interactor: JokesInteractor,
    private val executors: ExecutorsProvider
) : BasePresenter<JokesView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        Timber.e("test test")
        val jokesDataSource = JokesDataSource(compositeDisposable, executors) { num: Int -> interactor.getJokes(num) }
        viewState.bindJokes(jokesPagedList = jokesDataSource.getPagedList())
    }

    fun goToDetailed(joke:Joke,router: RouterProvider){
        interactor.joke = joke
        router.startFlow(R.id.actionMenuFragmentToDetailedJokeFragment)
    }
}