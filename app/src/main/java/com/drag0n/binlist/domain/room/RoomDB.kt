package com.drag0n.binlist.domain.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ItemHistoryDB::class],
    version = 1,
)
abstract class RoomDB: RoomDatabase() {
    abstract fun dao(): Dao
}