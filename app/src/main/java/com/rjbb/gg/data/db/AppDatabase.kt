package com.rjbb.gg.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rjbb.gg.data.db.entity.SearchHistoryEntity
import com.rjbb.gg.data.db.entity.FunctionEntity

@Database(
    entities = [
        SearchHistoryEntity::class,
        FunctionEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun searchHistoryDao(): SearchHistoryDao
    abstract fun functionDao(): FunctionDao
}