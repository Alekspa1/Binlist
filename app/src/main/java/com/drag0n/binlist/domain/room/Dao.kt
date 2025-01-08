package com.drag0n.binlist.domain.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface Dao {
    @Query("SELECT * FROM ItemHistoryDB")
    fun getAll(): LiveData<List<ItemHistoryDB>>
    @Insert
    suspend fun insert(item: ItemHistoryDB)
}