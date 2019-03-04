package com.yakow.weber.myapplication.ui.jokes.adapter

import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.yakow.weber.myapplication.entity.Joke
import com.yakow.weber.myapplication.toothpick.system.executor.ExecutorsProvider
import com.yakow.weber.myapplication.toothpick.system.network.state.NetworkState
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import timber.log.Timber

/**
 * Created on 28.02.19
 * @author YWeber */
private const val SIZE_LIST = 100
class JokesDataSource(
    private val compositeDisposable: CompositeDisposable,
    private val executors:ExecutorsProvider,
    private val getJokes: (num:Int) -> Single<List<Joke>>

) : PositionalDataSource<Joke>() {

    val stateNotifier: PublishSubject<NetworkState> = PublishSubject.create<NetworkState>()

    private val config = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setPageSize(SIZE_LIST)
        .build()

    fun getPagedList() = PagedList.Builder(this, config)
        .setFetchExecutor(executors.newSingleThreadExecutor())
        .setNotifyExecutor(executors.mainThreadExecutor())
        .build()

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Joke>) {
        stateNotifier.onNext(NetworkState.Loading)
        val disposable = getJokes(params.requestedLoadSize)
            .subscribe({
                stateNotifier.onNext(NetworkState.Loaded)
                callback.onResult(it, params.requestedStartPosition)
            }, {
                stateNotifier.onError(it)
                Timber.e(it)
            })
        compositeDisposable.add(disposable)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Joke>) {
        stateNotifier.onNext(NetworkState.Loading)
        val disposable = getJokes(params.loadSize)
            .subscribe({
                stateNotifier.onNext(NetworkState.Loaded)
                callback.onResult(it)
            }, {
                stateNotifier.onError(it)
                Timber.e(it)
            })
        compositeDisposable.add(disposable)
    }
}