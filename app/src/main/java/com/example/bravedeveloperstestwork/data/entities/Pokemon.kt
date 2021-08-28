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
    val name: String,
    val weight: Int?,
    val height: Int?,
    val sprite: String?,
    @ColumnInfo(name = "is_favourite")
    var isFavourite: Boolean = false
){
    @ColumnInfo(name = "pokemon_id")
    @PrimaryKey(autoGenerate = true)
    var id = 0
}

