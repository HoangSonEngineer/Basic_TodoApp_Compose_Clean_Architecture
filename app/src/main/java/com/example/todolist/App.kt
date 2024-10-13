package com.example.todolist

import android.app.Application
import com.example.todolist.di.todoAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                todoAppModule
            )
        }
    }
}