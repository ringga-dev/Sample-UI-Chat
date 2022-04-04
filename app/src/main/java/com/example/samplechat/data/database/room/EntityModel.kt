package com.example.samplechat.data.database.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Chat(
    @ColumnInfo(name = "user_id") val user_id: String,
    @ColumnInfo(name = "room_chat") val room_chat: String?,
    @ColumnInfo(name = "message") val message: String?,
    @ColumnInfo(name = "time") val time: String?,
    @ColumnInfo(name = "stts_chat") val stts_chat: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}