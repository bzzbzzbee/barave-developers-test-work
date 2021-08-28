package com.example.bravedeveloperstestwork.data

import androidx.room.*
import com.example.bravedeveloperstestwork.data.entities.PokemonHolder
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonHolderDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pokemonHolder: PokemonHolder): Long

    @Query("SELECT * FROM pokemon_holder WHERE name IN(:name)")
    fun getPokemonByName(name: String): Flow<PokemonHolder>

    @Query("SELECT * FROM pokemon_holder")
    fun getAllHolders(): Flow<List<PokemonHolder>>

    @Query("SELECT COUNT(id) FROM pokemon_holder")
    fun countPokemons(): Long
}