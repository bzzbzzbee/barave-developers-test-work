package com.example.bravedeveloperstestwork.data.entities

import androidx.room.*
import com.example.bravedeveloperstestwork.ABILITIES_TABLE_NAME

@Entity(tableName = ABILITIES_TABLE_NAME)
data class Ability(
    val name: String,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ability_id")
    var id: Int = 0
}

data class PokemonWithAbilities(
    @Embedded val pokemon: Pokemon,
    @Relation(
        parentColumn = "pokemon_id",
        entityColumn = "ability_id"
    )
    val abilities: List<Ability>
)