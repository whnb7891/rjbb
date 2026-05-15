package com.rjbb.gg.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "search_history")
data class SearchHistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val value: String,
    val dataType: String,
    val resultCount: Int,
    val timestamp: Long = System.currentTimeMillis()
)