package com.example.bravedeveloperstestwork.di

import dagger.Module

@Module(includes = [RetrofitModule::class, DbModule::class])
class AppModule