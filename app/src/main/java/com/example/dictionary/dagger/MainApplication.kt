package com.example.dictionary.dagger

import android.content.Context
import com.example.dictionary.networkstatus.NetworkStatus
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MainApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<MainApplication> =
        DaggerMainComponent.builder()
            .withContext(applicationContext)
            .withSharedPrefs(applicationContext.getSharedPreferences("SETTINGS", Context.MODE_PRIVATE))
            .withNetworkStatus(NetworkStatus(applicationContext))
            .build()
}