package com.yakow.weber.myapplication.model.repository

import com.yakow.weber.myapplication.entity.Joke
import com.yakow.weber.myapplication.extension.printConstruction
import com.yakow.weber.myapplication.model.data.server.Api
import com.yakow.weber.myapplication.toothpick.system.schedulers.SchedulersProvider
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created on 26.02.19
 * @author YWeber */

class JokesRepository @Inject constructor(
    private val api: Api,
    private val schedulers: SchedulersProvider
) {
    init {
        printConstruction()
    }

    fun getListJoke(num:Int): Single<List<Joke>> = api.getJokes(num)
        .map { it.map { jokeResponse -> Joke.convertResponseToEntity(jokeResponse) } }
        .subscribeOn(schedulers.io())
        .observeOn(schedulers.ui())
}