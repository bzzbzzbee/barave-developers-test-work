package com.example.bravedeveloperstestwork.data

import android.util.Log
import com.example.bravedeveloperstestwork.URL
import com.example.bravedeveloperstestwork.api.PokemonApi
import com.example.bravedeveloperstestwork.data.entities.PokemonHolder
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(
    private val pokemonApi: PokemonApi,
    private val pokemonDao: PokemonDao
) {
    suspend fun populateDb(){
        try {
            var url = URL
            var response = pokemonApi.loadResponse(url)

            if (response.isSuccessful) {
                var  responseResult = response.body()
                var pokemons = responseResult?.results

                pokemons?.forEach { pokemon ->
                    val pokemonHolder = PokemonHolder(pokemon.name, pokemon.url)
                    pokemonDao.insert(pokemonHolder)
                }

                while (!responseResult?.next.isNullOrEmpty()) {
                    url = responseResult?.next!!
                    response = pokemonApi.loadResponse(url)

                    if (response.isSuccessful) {
                        responseResult = response.body()
                        pokemons = responseResult?.results

                        pokemons?.forEach { pokemon ->
                            val pokemonHolder = PokemonHolder(pokemon.name, pokemon.url)
                            pokemonDao.insert(pokemonHolder)
                        }
                    }
                }
            }
        } catch (t: Throwable) {
            //for now
            Log.e("Db populating ex: ", t.message.toString())
        }
    }
}