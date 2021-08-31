package com.example.bravedeveloperstestwork.fragments

import android.content.Context
import androidx.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bravedeveloperstestwork.R
import com.example.bravedeveloperstestwork.data.entities.PokemonHolder
import com.example.bravedeveloperstestwork.databinding.SearchScreenBinding
import com.example.bravedeveloperstestwork.di.appComponent
import com.example.bravedeveloperstestwork.ui.SearchScreenViewModel
import javax.inject.Inject

class SearchFragment : Fragment() {
    private var _binding: SearchScreenBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var searchScreenViewModel: SearchScreenViewModel

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SearchScreenBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val adapter =
            ArrayAdapter<String>(requireContext(), R.layout.support_simple_spinner_dropdown_item)

        searchScreenViewModel.getPokemonNames().observe(this, { pokemonHolders ->
            pokemonHolders.forEach {
                adapter.add(it.name)
            }
        })

        binding.autoCompleteTextPokemonName.setAdapter(adapter)

        binding.buttonSearch.setOnClickListener {
            val name = binding.autoCompleteTextPokemonName.text.toString()

            if (searchScreenViewModel.getPokemon(name) != null) {
                //TODO pokemon card transition + safe args "name"
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.pokemon_doesnt_exist),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}