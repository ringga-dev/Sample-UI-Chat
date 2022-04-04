package com.example.samplechat.data.database.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ChatDao {
    @Query("SELECT * FROM chat")
    fun getChat(): List<Chat>

    @Insert
    fun insert(vararg chatDb: Chat)

    @Delete
    fun delete(chatDb: Chat)
}