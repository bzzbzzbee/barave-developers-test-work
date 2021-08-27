package com.example.bravedeveloperstestwork.data

import androidx.room.*
import com.example.bravedeveloperstestwork.data.entities.PokemonHolder
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonHolderDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pokemonHolder: PokemonHolder): Long

    @Query("SELECT * FROM pokemon_holder")
    fun getAllHolders(): Flow<List<PokemonHolder>>

    @Query("SELECT COUNT(name) FROM pokemon_holder")
    fun countPokemons(): Flow<Long>
}