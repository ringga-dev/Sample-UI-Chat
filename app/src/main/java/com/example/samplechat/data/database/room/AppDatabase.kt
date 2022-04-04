package com.example.samplechat.data.database.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Chat::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun chatDao(): ChatDao
}