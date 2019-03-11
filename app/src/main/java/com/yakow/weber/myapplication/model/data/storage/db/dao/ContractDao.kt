package com.yakow.weber.myapplication.model.data.storage.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created on 05.03.19
 * @author YWeber */
interface ContractDao<in Key : Any, Value : Any> {
    @Insert(onConflict = REPLACE)
    fun insert(element: Value)

    @Insert(onConflict = REPLACE)
    @JvmSuppressWildcards
    fun insertAll(elements: List<Value>)

    @Delete
    fun delete(element: Value)

}