package com.example.bravedeveloperstestwork.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.bravedeveloperstestwork.data.PokemonRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import kotlin.math.absoluteValue

class MenuFragmentViewModel @Inject constructor(private val repository: PokemonRepository): ViewModel() {

    fun countPokemonHolders() = repository.countPokemonHolders
    fun countFavouritePokemons() = repository.countFavouritePokemons
}