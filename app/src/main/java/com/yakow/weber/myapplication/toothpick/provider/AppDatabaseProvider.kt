package com.yakow.weber.myapplication.toothpick.provider

import android.content.Context
import androidx.room.Room
import com.yakow.weber.myapplication.model.data.storage.db.AppDatabase
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created on 06.03.19
 * @author YWeber */

class AppDatabaseProvider @Inject constructor(private val context: Context) : Provider<AppDatabase> {
    override fun get(): AppDatabase = Room
        .databaseBuilder(context, AppDatabase::class.java, "database_room")
        .build()
}