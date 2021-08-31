package com.example.bravedeveloperstestwork.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.bravedeveloperstestwork.data.PokemonRepository
import javax.inject.Inject

class SearchScreenViewModel @Inject constructor(private val repository: PokemonRepository) :ViewModel() {
    fun getPokemonNames() = repository.getPokemonNames().asLiveData()
    fun getPokemon(name: String) = repository.getPokemon(name)
}