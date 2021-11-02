package com.example.dictionary.dagger

import com.example.dictionary.model.datasource.*
import com.example.dictionary.networkstatus.NetworkStatus
import com.example.dictionary.networkstatus.NetworkStatusInterface
import com.example.dictionary.view.viewmodel.ListFragmentViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val application = module {
    single <ApiHolder> { ApiHolder() }
    single <NetworkStatusInterface> { NetworkStatus (androidContext()) }
    single <RemoteDataSourceInterface> { RemoteDataSource(apiHolder = get()) }
    single <LocalDataSourceInterface> { LocalDataSource() }
}

val listFragment = module {
    factory { DataProvider(
        networkStatus = get(),
        remoteDataSource = get(),
        localDataSource = get()) }
    viewModel { ListFragmentViewModel() }
}