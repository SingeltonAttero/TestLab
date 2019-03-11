package com.yakow.weber.myapplication.model.data.storage.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yakow.weber.myapplication.model.data.storage.db.dao.JokesDao
import com.yakow.weber.myapplication.model.data.storage.db.entity.JokeEntity

/**
 * Created on 05.03.19
 * @author YWeber */
@Database(
    entities = [JokeEntity::class],
    version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun jokeDao(): JokesDao
}