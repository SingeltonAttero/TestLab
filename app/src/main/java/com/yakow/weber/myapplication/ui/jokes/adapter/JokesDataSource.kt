package com.yakow.weber.myapplication.ui.jokes.adapter

import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.yakow.weber.myapplication.entity.Joke
import com.yakow.weber.myapplication.toothpick.system.executor.ExecutorsProvider
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

/**
 * Created on 28.02.19
 * @author YWeber */
private val SIZE_LIST = 40
class JokesDataSource(
    private val compositeDisposable: CompositeDisposable,
    private val executors:ExecutorsProvider,
    private val getJokes: (num:Int) -> Single<List<Joke>>

) : PositionalDataSource<Joke>() {

    private val config = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setPageSize(SIZE_LIST)
        .build()

    fun getPagedList() = PagedList.Builder(this, config)
        .setFetchExecutor(executors.newSingleThreadExecutor())
        .setNotifyExecutor(executors.mainThreadExecutor())
        .build()

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Joke>) {
        val disposable = getJokes(params.requestedLoadSize)
            .subscribe({ callback.onResult(it, params.requestedStartPosition) }, { Timber.e(it) })
        compositeDisposable.add(disposable)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Joke>) {
        val disposable = getJokes(params.loadSize)
            .subscribe({ callback.onResult(it) }, { Timber.e(it) })
        compositeDisposable.add(disposable)
    }
}