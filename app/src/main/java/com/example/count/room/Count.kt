package com.example.count.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "count_table")
data class CountEntity(
    @PrimaryKey val name: String,
    val count: Int
)