package com.example.bravedeveloperstestwork.data.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import com.example.bravedeveloperstestwork.POKEMON_WITH_ABILITY_TABLE_NAME

data class PokemonWithAbilities(
    @Embedded val pokemon: Pokemon,
    @Relation(
        parentColumn = "pokemon_id",
        entityColumn = "ability_owner_id"
    )
    val abilities: List<Ability>
)