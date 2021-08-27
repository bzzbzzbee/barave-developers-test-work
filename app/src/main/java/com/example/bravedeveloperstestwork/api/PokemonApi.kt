package com.example.bravedeveloperstestwork.api


import com.example.bravedeveloperstestwork.data.Root
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url


interface PokemonApi {
    @GET
    suspend fun loadResponse(@Url  url: String): Response<Root>

    @GET
    suspend fun loadPokemon(@Url url: String): Response<com.example.bravedeveloperstestwork.data.pojo.Response>
}
