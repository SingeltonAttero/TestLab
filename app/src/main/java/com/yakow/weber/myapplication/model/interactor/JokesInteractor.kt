package com.yakow.weber.myapplication.model.interactor

import com.yakow.weber.myapplication.entity.Joke
import com.yakow.weber.myapplication.extension.printConstruction
import com.yakow.weber.myapplication.model.repository.JokesRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created on 26.02.19
 * @author YWeber */
 
class JokesInteractor @Inject constructor(private val repository: JokesRepository){
    init {
        printConstruction()
    }
    fun getJokes(num:Int): Single<List<Joke>> = repository.getListJoke(num)
}