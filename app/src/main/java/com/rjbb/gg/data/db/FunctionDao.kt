package com.rjbb.gg.data.db

import androidx.room.*
import com.rjbb.gg.data.db.entity.FunctionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FunctionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(function: FunctionEntity)

    @Query("SELECT * FROM functions")
    fun getAllFunctions(): Flow<List<FunctionEntity>>

    @Query("SELECT * FROM functions WHERE name = :name")
    suspend fun getFunctionByName(name: String): FunctionEntity?

    @Delete
    suspend fun delete(function: FunctionEntity)

    @Query("DELETE FROM functions")
    suspend fun deleteAll()
}