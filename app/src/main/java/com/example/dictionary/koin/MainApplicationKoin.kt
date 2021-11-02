package com.example.dictionary.koin

import android.app.Application
import com.example.dictionary.dagger.application
import com.example.dictionary.dagger.listFragment
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MainApplicationKoin : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            printLogger()
            androidContext(applicationContext)
            modules(listOf(application, listFragment))
        }

        Timber.plant(Timber.DebugTree())
    }

}