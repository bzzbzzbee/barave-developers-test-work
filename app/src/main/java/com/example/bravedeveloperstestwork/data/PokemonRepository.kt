package com.example.bravedeveloperstestwork.data

import android.util.Log
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import com.example.bravedeveloperstestwork.URL
import com.example.bravedeveloperstestwork.api.PokemonApi
import com.example.bravedeveloperstestwork.data.entities.Ability
import com.example.bravedeveloperstestwork.data.entities.Pokemon
import com.example.bravedeveloperstestwork.data.entities.PokemonHolder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(
    private val pokemonApi: PokemonApi,
    private val pokemonDao: PokemonDao,
    private val pokemonHolderDao: PokemonHolderDao
) {
    val countPokemonHolders = runBlocking { pokemonHolderDao.countPokemons() }
    val countFavouritePokemons = runBlocking { pokemonDao.countFavouritePokemons() }

    fun getPokemonNames() = pokemonHolderDao.getAllHolders()

    suspend fun fetchPokemonHolders() {
        try {
            var url = URL
            var response = pokemonApi.loadResponse(url)

            if (response.isSuccessful) {
                var responseResult = response.body()
                var pokemons = responseResult?.results
                var pokemonList: List<PokemonHolder>? =
                    pokemons?.map { PokemonHolder(it.name, it.url) }

                if (!pokemonList.isNullOrEmpty()) {
                    pokemonHolderDao.insert(pokemonList)
                }

                while (!responseResult?.next.isNullOrEmpty()) {
                    url = responseResult?.next!!
                    response = pokemonApi.loadResponse(url)

                    if (response.isSuccessful) {
                        responseResult = response.body()
                        pokemons = responseResult?.results
                        pokemonList = pokemons?.map { PokemonHolder(it.name, it.url) }

                        if (!pokemonList.isNullOrEmpty()) {
                            pokemonHolderDao.insert(pokemonList)
                        }
                    } else break
                }
            }
        } catch (t: Throwable) {
            //for now
            Log.e("Db populating ex: ", t.message.toString())
        }
    }

    //TODO ASSERTIONS???
    suspend fun getPokemonByName(name: String) {
        val pokemonHolder = pokemonHolderDao.getPokemonByName(name)

        try {
            val response = pokemonApi.loadPokemon(pokemonHolder!!.url)

            if (response.isSuccessful) {
                val pokemonResponse = response.body()
                val pokemon = Pokemon(
                    pokemonResponse?.name!!,
                    pokemonResponse.weight,
                    pokemonResponse.height,
                    pokemonResponse.sprites?.frontDefault
                )

                val pokemonId = pokemonDao.insert(pokemon).toInt()

                if (pokemonId == -1) {
                    throw Throwable("Existing pokemon")
                }

                val abilities: List<Ability>? =
                    pokemonResponse.abilities?.map { ability ->
                        Ability(ability?.ability?.name!!, pokemonId)
                    }

                if (!abilities.isNullOrEmpty()) {
                    pokemonDao.insert(abilities)
                }
            }
        } catch (t: Throwable) {
            //for now
            Log.e("Db populating ex: ", t.message.toString())
        }
    }

    fun getPokemon(name: String) = runBlocking { pokemonHolderDao.getPokemonByName(name) }
}