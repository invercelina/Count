package com.example.count.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountDao {
    @Query("SELECT * FROM count_table WHERE id = 1")
    suspend fun getCount(): CountEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCount(count: CountEntity)
}