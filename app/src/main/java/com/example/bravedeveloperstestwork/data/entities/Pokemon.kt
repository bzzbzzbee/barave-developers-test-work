package com.example.bravedeveloperstestwork.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.bravedeveloperstestwork.POKEMON_TABLE_NAME

@Entity(tableName = POKEMON_TABLE_NAME,
    indices = [Index(value = ["name"], unique = true)]
)
data class Pokemon(
    @ColumnInfo(name = "pokemon_id")
    @PrimaryKey
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val sprite: String?,
    @ColumnInfo(name = "is_favourite")
    val isFavourite: Boolean
)

