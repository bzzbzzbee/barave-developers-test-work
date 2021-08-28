package com.example.bravedeveloperstestwork.data

import android.util.Log
import com.example.bravedeveloperstestwork.URL
import com.example.bravedeveloperstestwork.api.PokemonApi
import com.example.bravedeveloperstestwork.data.entities.Ability
import com.example.bravedeveloperstestwork.data.entities.Pokemon
import com.example.bravedeveloperstestwork.data.entities.PokemonHolder
import com.example.bravedeveloperstestwork.data.entities.PokemonWithAbilities
import kotlinx.coroutines.flow.single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(
    private val pokemonApi: PokemonApi,
    private val pokemonDao: PokemonDao,
    private val pokemonHolderDao: PokemonHolderDao
) {
    //TODO ASSERTIONS???
    suspend fun populateDb() {
        try {
            var url = URL
            var response = pokemonApi.loadResponse(url)

            if (response.isSuccessful) {
                var responseResult = response.body()
                var pokemons = responseResult?.results

                pokemons?.forEach { pokemon ->
                    val pokemonHolder = PokemonHolder(pokemon.name, pokemon.url)
                    pokemonHolderDao.insert(pokemonHolder)
                }

                while (!responseResult?.next.isNullOrEmpty()) {
                    url = responseResult?.next!!
                    response = pokemonApi.loadResponse(url)

                    if (response.isSuccessful) {
                        responseResult = response.body()
                        pokemons = responseResult?.results

                        pokemons?.forEach { pokemon ->
                            val pokemonHolder = PokemonHolder(pokemon.name, pokemon.url)
                            pokemonHolderDao.insert(pokemonHolder)
                        }
                    }
                }
            }
        } catch (t: Throwable) {
            //for now
            Log.e("Db populating ex: ", t.message.toString())
        }
    }

    suspend fun getPokemon(name: String) {
        val pokemonHolder = pokemonHolderDao.getPokemonByName(name).single()

        try {
            val response = pokemonApi.loadPokemon(pokemonHolder.url)

            if (response.isSuccessful) {
                val pokemonResponse = response.body()
                val pokemon = Pokemon(
                    pokemonResponse?.name!!,
                    pokemonResponse.weight,
                    pokemonResponse.height,
                    pokemonResponse.sprites?.frontDefault
                )

                val pokemonId = pokemonDao.insert(pokemon).toInt()
                if(pokemonId == -1) {
                    throw Throwable("Existing pokemon")
                }

                val abilities: MutableList<Ability> = mutableListOf()
                pokemonResponse.abilities?.forEach { ability->
                    val abil = Ability(ability?.ability?.name!!, pokemonId)
                    abilities.add(abil)
                }

                pokemonDao.insert(abilities)
            }
        } catch (t: Throwable) {
            //for now
            Log.e("Db populating ex: ", t.message.toString())
        }
    }
}