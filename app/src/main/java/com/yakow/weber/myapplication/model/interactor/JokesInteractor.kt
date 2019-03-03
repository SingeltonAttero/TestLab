package com.yakow.weber.myapplication.model.interactor

import com.yakow.weber.myapplication.entity.Joke
import com.yakow.weber.myapplication.extension.printConstruction
import com.yakow.weber.myapplication.model.repository.JokesRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created on 26.02.19
 * @author YWeber */
private const val DELETE_CONTENT_XKCDB = "XKCDB"
class JokesInteractor @Inject constructor(private val repository: JokesRepository){
    init {
        printConstruction()
    }

    var joke: Joke
        get() = repository.currentJoke
        set(value) {
            repository.currentJoke = value
        }

    fun getJokes(num: Int): Single<List<Joke>> = repository.getListJoke(num)
            .map { jokes -> jokes.filter { it.description != DELETE_CONTENT_XKCDB } }
}
