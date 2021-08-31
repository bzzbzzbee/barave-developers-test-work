package com.example.bravedeveloperstestwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bravedeveloperstestwork.databinding.ActivityMainBinding
import com.example.bravedeveloperstestwork.di.appComponent
import com.example.bravedeveloperstestwork.ui.MainActivityViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @Inject lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
    }
}