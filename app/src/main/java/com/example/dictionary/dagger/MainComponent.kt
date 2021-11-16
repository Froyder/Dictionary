package com.example.dictionary.dagger

import android.content.Context
import android.content.SharedPreferences
import com.example.utils.networkStatus.NetworkStatusInterface
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ViewsBindsModule::class,
        ProvidesModule::class])
interface MainComponent: AndroidInjector<MainApplicationDagger> {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withSharedPrefs (sharedPrefs: SharedPreferences): Builder

        @BindsInstance
        fun withNetworkStatus (networkStatus: NetworkStatusInterface): Builder

        fun build(): MainComponent
    }
}