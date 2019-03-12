package com.yakow.weber.myapplication.model.interactor

import com.yakow.weber.myapplication.entity.Favorites
import com.yakow.weber.myapplication.extension.printConstruction
import com.yakow.weber.myapplication.model.repository.FavoritesRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created on 12.03.19
 * @author YWeber */

class FavoritesInteractor @Inject constructor (private val repository: FavoritesRepository) {
    init {
        printConstruction()
    }

    fun getAllFavorites(): Single<List<Favorites>> = repository.getAllFavorites()
}