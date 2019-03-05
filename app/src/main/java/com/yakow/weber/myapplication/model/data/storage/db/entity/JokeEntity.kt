package com.yakow.weber.myapplication.model.data.storage.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created on 05.03.19
 * @author YWeber */

@Entity(tableName = "table_joke")
class JokeEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val content: String,
    val sourceJoke: String
)