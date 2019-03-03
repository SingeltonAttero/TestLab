package com.yakow.weber.myapplication.presenter.jokes

import androidx.paging.PagedList
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
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(40)
            .build()
        Timber.e("test test")
        val jokesDataSource = JokesDataSource(compositeDisposable) { num: Int -> interactor.getJokes(num) }
        val pageList = PagedList.Builder(jokesDataSource, config)
            .setFetchExecutor(executors.newSingleThreadExecutor())
            .setNotifyExecutor(executors.mainThreadExecutor())
            .build()
        viewState.bindJokes(pageList)
    }

    fun goToDetailed(joke:Joke,router: RouterProvider){
        interactor.joke = joke
        router.startFlow(R.id.actionMenuFragmentToDetailedJokeFragment)
    }

}