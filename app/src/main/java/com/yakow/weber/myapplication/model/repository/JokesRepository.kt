package com.yakow.weber.myapplication.model.repository

import com.yakow.weber.myapplication.entity.Joke
import com.yakow.weber.myapplication.extension.printConstruction
import com.yakow.weber.myapplication.model.data.server.Api
import com.yakow.weber.myapplication.model.data.storage.db.dao.JokesDao
import com.yakow.weber.myapplication.model.data.storage.db.entity.JokeEntity
import com.yakow.weber.myapplication.toothpick.system.schedulers.SchedulersProvider
import io.reactivex.Completable
import io.reactivex.Single
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import javax.inject.Inject

/**
 * Created on 26.02.19
 * @author YWeber */

class JokesRepository @Inject constructor(
    private val api: Api,
    private val schedulers: SchedulersProvider,
    private val dao: JokesDao
) {
    init {
        printConstruction()
    }
    lateinit var currentJoke:Joke

    fun saveJokeFromDb(joke: Joke): Completable = Completable.fromAction {
        val entity = JokeEntity(
            content = joke.content, sourceJoke = joke.description, saveDate = DateTime(DateTimeZone.UTC).toString()
        )
        dao.insert(entity)
    }.subscribeOn(schedulers.io())
        .observeOn(schedulers.ui())

    fun getListJoke(num:Int): Single<List<Joke>> = api.getJokes(num)
        .map { it.map { jokeResponse -> Joke.convertResponseToEntity(jokeResponse) } }
        .subscribeOn(schedulers.io())
        .observeOn(schedulers.ui())
}