package com.example.bravedeveloperstestwork.di

import android.app.Application
import android.content.Context


class MainApp : Application() {

    lateinit var appComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent
            .builder()
            .context(this)
            .build()
    }
}

val Context.appComponent: ApplicationComponent
    get() = when (this) {
        is MainApp -> appComponent
        else -> this.applicationContext.appComponent
    }