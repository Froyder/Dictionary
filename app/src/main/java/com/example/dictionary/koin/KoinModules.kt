package com.example.dictionary.koin

import androidx.room.Room
import com.example.database.DictionaryDatabase
import com.example.dataprovider.ApiHolder
import com.example.dataprovider.DataProvider
import com.example.dataprovider.DataProviderInterface
import com.example.dataprovider.datasources.LocalDataSource
import com.example.dataprovider.datasources.LocalDataSourceInterface
import com.example.dataprovider.datasources.RemoteDataSource
import com.example.dataprovider.datasources.RemoteDataSourceInterface
import com.example.utils.networkStatus.NetworkStatus
import com.example.utils.networkStatus.NetworkStatusInterface
import com.example.dictionary.view.viewmodel.DetailsViewModel
import com.example.dictionary.view.viewmodel.FavoritesViewModel
import com.example.dictionary.view.viewmodel.HistoryViewModel
import com.example.dictionary.view.viewmodel.ListFragmentViewModel
import com.example.utils.MIGRATION_2_3
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val LIST_SCOPE = "list_scope"
private const val HISTORY_SCOPE = "history_scope"
private const val FAVORITES_SCOPE = "favorites_scope"
private const val DETAILS_SCOPE = "details_scope"

val application = module {
    single { ApiHolder() }
    single <NetworkStatusInterface> { NetworkStatus(androidContext()) }
    single <RemoteDataSourceInterface> { RemoteDataSource(apiHolder = get()) }
    single <LocalDataSourceInterface> { LocalDataSource() }
    single {
        Room.databaseBuilder(androidContext(), DictionaryDatabase::class.java, "words_database")
            .addMigrations(MIGRATION_2_3)
            .build()
    }
}

val fragments = module {
    scope (named(LIST_SCOPE)) {
        scoped <DataProviderInterface>{
            DataProvider(networkStatus = get(), remoteDataSource = get(), localDataSource = get())
        }
        viewModel { ListFragmentViewModel(get()) }
    }

    scope (named(HISTORY_SCOPE)){
        scoped <DataProviderInterface>{
            DataProvider(networkStatus = get(), remoteDataSource = get(), localDataSource = get())
        }
        viewModel { HistoryViewModel(get()) }
    }

    scope (named(FAVORITES_SCOPE)){
        scoped <DataProviderInterface>{
            DataProvider(networkStatus = get(), remoteDataSource = get(), localDataSource = get())
        }
        viewModel { FavoritesViewModel(get()) }
    }

    scope (named(DETAILS_SCOPE)){
        scoped <DataProviderInterface>{
            DataProvider(networkStatus = get(), remoteDataSource = get(), localDataSource = get())
        }
        viewModel { DetailsViewModel(get()) }
    }
}