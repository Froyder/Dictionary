package com.example.dictionary.koin

import androidx.room.Room
import com.example.dictionary.MIGRATION_2_3
import com.example.dictionary.model.datasource.*
import com.example.dictionary.model.datasource.database.DictionaryDatabase
import com.example.dictionary.networkstatus.NetworkStatus
import com.example.dictionary.networkstatus.NetworkStatusInterface
import com.example.dictionary.view.viewmodel.DetailsViewModel
import com.example.dictionary.view.viewmodel.FavoritesViewModel
import com.example.dictionary.view.viewmodel.HistoryViewModel
import com.example.dictionary.view.viewmodel.ListFragmentViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val application = module {
    single <ApiHolder> { ApiHolder() }
    single <NetworkStatusInterface> { NetworkStatus (androidContext()) }
    single <RemoteDataSourceInterface> { RemoteDataSource(apiHolder = get()) }
    single <LocalDataSourceInterface> { LocalDataSource() }
    single {
        Room.databaseBuilder(androidContext(), DictionaryDatabase::class.java, "words_database")
            .addMigrations(MIGRATION_2_3)
            .build()
    }
}

val listFragment = module {
    factory {
        DataProvider(networkStatus = get(), remoteDataSource = get(), localDataSource = get())
    }
    viewModel { ListFragmentViewModel() }
}

val historyFragment = module {
    viewModel { HistoryViewModel() }
}

val favoritesFragment = module {
    viewModel { FavoritesViewModel() }
}

val detailsFragment = module {
    viewModel { DetailsViewModel() }
}