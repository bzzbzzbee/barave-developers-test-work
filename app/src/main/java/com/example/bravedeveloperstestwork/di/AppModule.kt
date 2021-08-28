package com.example.bravedeveloperstestwork.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule: Application() {

    val appComponent = DaggerApplicationComponent.create()

    @Singleton
    @Provides
    @ApplicationContext
    fun provideContext(): Context? {
        return applicationContext
    }
}