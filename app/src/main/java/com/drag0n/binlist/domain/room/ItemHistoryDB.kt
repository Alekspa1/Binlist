package com.drag0n.binlist.domain.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemHistoryDB(
    @PrimaryKey var id: Int?,
    @ColumnInfo val bin: String,
    @ColumnInfo val country: String,
    @ColumnInfo val location: String,
    @ColumnInfo val cardType: String,
    @ColumnInfo val url: String,
    @ColumnInfo val phone: String,
    @ColumnInfo val city: String,
)