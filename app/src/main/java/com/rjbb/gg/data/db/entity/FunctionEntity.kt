package com.rjbb.gg.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "functions")
data class FunctionEntity(
    @PrimaryKey
    val name: String,
    val code: String,
    val description: String,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)