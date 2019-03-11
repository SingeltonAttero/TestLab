package com.yakow.weber.myapplication.toothpick.provider

import com.yakow.weber.myapplication.model.data.storage.db.AppDatabase
import com.yakow.weber.myapplication.model.data.storage.db.dao.JokesDao
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created on 06.03.19
 * @author YWeber */

class JokeDaoProvider @Inject constructor(private val database: AppDatabase) : Provider<JokesDao> {
    override fun get(): JokesDao = database.jokeDao()
}