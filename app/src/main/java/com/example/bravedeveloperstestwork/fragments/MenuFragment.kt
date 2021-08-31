package com.example.bravedeveloperstestwork.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bravedeveloperstestwork.R
import com.example.bravedeveloperstestwork.databinding.MenuScreenBinding
import com.example.bravedeveloperstestwork.di.appComponent
import com.example.bravedeveloperstestwork.ui.MenuFragmentViewModel
import javax.inject.Inject
import kotlin.math.absoluteValue

class MenuFragment : Fragment() {
    private var _binding: MenuScreenBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var menuViewModel: MenuFragmentViewModel

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MenuScreenBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.searchButton.setOnClickListener {
            if (isPokemonsFetched()) {
                //TODO go to search fragment
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.no_available_search),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.randomButton.setOnClickListener {
            if (isPokemonsFetched()) {
                //TODO go to random pokemon fragment
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.no_available_random),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.favouriteButton.setOnClickListener {
            if (menuViewModel.countFavouritePokemons() > 0) {
                //TODO go to favourite fragment
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.no_favourite),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun isPokemonsFetched() = menuViewModel.countPokemonHolders() > 0

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}