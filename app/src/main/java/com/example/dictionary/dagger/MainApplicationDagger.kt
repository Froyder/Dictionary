package com.example.dictionary.dagger

import android.content.Context
import com.example.dictionary.networkstatus.NetworkStatus
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

class MainApplicationDagger: DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<MainApplicationDagger> =
        DaggerMainComponent.builder()
            .withContext(applicationContext)
            .withSharedPrefs(applicationContext.getSharedPreferences(SETTINGS, Context.MODE_PRIVATE))
            .withNetworkStatus(NetworkStatus(applicationContext))
            .build()

    companion object {
        private const val SETTINGS = "SETTINGS"
    }

}