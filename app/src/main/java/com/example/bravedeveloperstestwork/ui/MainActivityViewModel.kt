package com.example.bravedeveloperstestwork.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bravedeveloperstestwork.data.PokemonRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val repository: PokemonRepository) : ViewModel() {
    init {
        viewModelScope.launch {
            repository.fetchPokemonHolders()
        }
    }
}