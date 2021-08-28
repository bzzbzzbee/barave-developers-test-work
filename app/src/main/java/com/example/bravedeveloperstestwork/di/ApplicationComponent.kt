package com.example.bravedeveloperstestwork.di

import android.content.Context
import com.example.bravedeveloperstestwork.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, DbModule::class, AppModule::class])
interface ApplicationComponent {
    //TODO РАЗОБРАТЬСЯ С DI
    //(applicationContext as MyApplication).appComponent.inject(this) to inject view Model foe e.g
    fun inject(activity: MainActivity)

    @ApplicationContext
    fun getContext(): Context?
}