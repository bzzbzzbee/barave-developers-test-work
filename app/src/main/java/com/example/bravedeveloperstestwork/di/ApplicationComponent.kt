package com.example.bravedeveloperstestwork.di

import android.content.Context
import com.example.bravedeveloperstestwork.MainActivity
import com.example.bravedeveloperstestwork.api.PokemonApi
import com.example.bravedeveloperstestwork.data.PokemonDb
import com.example.bravedeveloperstestwork.fragments.MenuFragment
import com.example.bravedeveloperstestwork.fragments.SplashScreenFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface ApplicationComponent {
    val db: PokemonDb
    val api: PokemonApi

    fun inject(fragment: SplashScreenFragment)
    fun inject(fragment: MenuFragment)
    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): ApplicationComponent
    }
}