package com.example.bravedeveloperstestwork.data.entities

import androidx.room.Embedded
import androidx.room.Relation

data class PokemonWithAbilities(
    @Embedded val pokemon: Pokemon,
    @Relation(
        parentColumn = "pokemon_id",
        entityColumn = "ability_owner_id"
    )
    val abilities: List<Ability>
)