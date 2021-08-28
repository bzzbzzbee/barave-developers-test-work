package com.example.bravedeveloperstestwork.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.bravedeveloperstestwork.ABILITIES_TABLE_NAME

@Entity(tableName = ABILITIES_TABLE_NAME)
data class Ability(
    val name: String,
    @ColumnInfo(name = "ability_owner_id")
    val abilityOwnerId: Int
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ability_id")
    var id: Int = 0
}

