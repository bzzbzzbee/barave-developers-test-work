package com.example.bravedeveloperstestwork.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.bravedeveloperstestwork.data.entities.Ability
import com.example.bravedeveloperstestwork.data.entities.Pokemon
import com.example.bravedeveloperstestwork.data.entities.PokemonWithAbilities
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pokemon: Pokemon): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(ability: Ability)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(abilities: List<Ability>)

    @Transaction
    @Query("SELECT * FROM pokemons ORDER BY name ASC")
    fun getPokemons(): Flow<List<PokemonWithAbilities>>

    @Transaction
    @Query("SELECT * FROM pokemons WHERE is_favourite = 1 ORDER BY name ASC")
    fun getFavouritePokemons(): Flow<List<PokemonWithAbilities>>

    @Query("SELECT COUNT(pokemon_id) FROM pokemons WHERE is_favourite = 1")
    suspend fun countFavouritePokemons(): Long
}