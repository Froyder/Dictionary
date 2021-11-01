package com.example.dictionary.dagger

import com.example.dictionary.view.ListFragment
import com.example.dictionary.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface BindsModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindListFragment(): ListFragment
}