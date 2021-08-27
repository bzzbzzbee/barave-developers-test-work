package com.example.bravedeveloperstestwork.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bravedeveloperstestwork.data.entities.Ability
import com.example.bravedeveloperstestwork.data.entities.Pokemon
import com.example.bravedeveloperstestwork.data.entities.PokemonHolder
import javax.inject.Singleton


@Database(
    entities = [Pokemon::class, Ability::class, PokemonHolder::class],
    version = 1,
    exportSchema = false
)

@Singleton
abstract class PokemonDb : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
    abstract fun pokemonHolderDao(): PokemonDao
}