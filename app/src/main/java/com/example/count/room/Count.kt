package com.example.count.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "count_table")
data class CountEntity(
    @PrimaryKey val id: Int = 1,
    val count: Int
)