package com.yakow.weber.myapplication.model.repository

import com.yakow.weber.myapplication.entity.Favorites
import com.yakow.weber.myapplication.extension.printConstruction
import com.yakow.weber.myapplication.model.data.storage.db.dao.JokesDao
import com.yakow.weber.myapplication.toothpick.system.schedulers.SchedulersProvider
import com.yakow.weber.myapplication.utils.fromString
import com.yakow.weber.myapplication.utils.userDateFormat
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created on 12.03.19
 * @author YWeber */

class FavoritesRepository @Inject constructor(
    private val dao: JokesDao,
    private val schedulers: SchedulersProvider
) {
    init {
        printConstruction()
    }

    fun getAllFavorites(): Single<List<Favorites>> = dao.getAll()
        .map {
            it.map { entity ->
                Favorites(
                    entity.sourceJoke, entity.content,
                    userDateFormat(fromString(entity.saveDate))
                )
            }
        }
        .subscribeOn(schedulers.io())
        .observeOn(schedulers.ui())
}