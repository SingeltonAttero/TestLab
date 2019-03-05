package com.yakow.weber.myapplication.model.data.storage.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.yakow.weber.myapplication.model.data.storage.db.entity.JokeEntity
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created on 05.03.19
 * @author YWeber */
@Dao
abstract class JokesDao : ContractDao<Long, JokeEntity> {
    @Query("SELECT * FROM table_joke")
    abstract fun getAll(): Flowable<List<JokeEntity>>

    @Query("SELECT * FROM table_joke WHERE id = :key")
    abstract fun getByKey(key: Long): Single<JokeEntity>

    @Query("DELETE FROM table_joke")
    abstract fun deleteAll()

    @Query("DELETE FROM table_joke WHERE id = :key")
    abstract fun deleteByKey(key: Long)
}