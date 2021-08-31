package com.example.bravedeveloperstestwork.di

import android.content.Context
import androidx.room.Room
import com.example.bravedeveloperstestwork.POKEMON_DB_NAME
import com.example.bravedeveloperstestwork.data.PokemonDb
import com.example.bravedeveloperstestwork.data.PokemonDao
import com.example.bravedeveloperstestwork.data.PokemonHolderDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    @Singleton
    @Provides
    fun providePokemonDatabase(context: Context): PokemonDb {
        return Room.databaseBuilder(
            context.applicationContext,
            PokemonDb::class.java,
            POKEMON_DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providePokemonDao(pokemonDataBase: PokemonDb) : PokemonDao {
        return pokemonDataBase.pokemonDao()
    }

    @Singleton
    @Provides
    fun providePokemonHolderDao(pokemonDataBase: PokemonDb) : PokemonHolderDao {
        return pokemonDataBase.pokemonHolderDao()
    }
}