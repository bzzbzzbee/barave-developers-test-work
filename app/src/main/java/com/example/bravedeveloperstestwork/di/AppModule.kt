package com.example.bravedeveloperstestwork.di

import android.app.Application
import com.example.bravedeveloperstestwork.MainActivity
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, DbModule::class])
interface ApplicationComponent {
    // This tells Dagger that LoginActivity requests injection so the graph needs to
    // satisfy all the dependencies of the fields that LoginActivity is requesting.
    //TODO если в активити не нужен инджект, то он и инжектить не надо
    //TODO РАЗОБРАТЬСЯ С DI
    fun inject(activity: MainActivity)
}

class MyApplication(): Application() {

    val appComponent = DaggerApplicationComponent.create()
}