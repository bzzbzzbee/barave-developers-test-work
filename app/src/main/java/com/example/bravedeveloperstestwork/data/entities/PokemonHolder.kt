package com.example.bravedeveloperstestwork.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.bravedeveloperstestwork.POKEMON_HOLDER_TABLE_NAME

@Entity(tableName = POKEMON_HOLDER_TABLE_NAME)
data class PokemonHolder(
    val name: String,
    val url: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}