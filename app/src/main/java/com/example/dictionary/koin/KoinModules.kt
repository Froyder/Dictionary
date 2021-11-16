package com.example.dictionary.koin

import androidx.room.Room
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
import org.koin.dsl.module

val application = module {
    single <com.example.dataprovider.ApiHolder> { com.example.dataprovider.ApiHolder() }
    single <NetworkStatusInterface> {
        NetworkStatus(
            androidContext()
        )
    }
    single <RemoteDataSourceInterface> {
        RemoteDataSource(
            apiHolder = get()
        )
    }
    single <LocalDataSourceInterface> { LocalDataSource() }
    single {
        Room.databaseBuilder(androidContext(), com.example.database.DictionaryDatabase::class.java, "words_database")
            .addMigrations(MIGRATION_2_3)
            .build()
    }
}

val listFragment = module {
    factory {
        com.example.dataprovider.DataProvider(
            networkStatus = get(),
            remoteDataSource = get(),
            localDataSource = get()
        )
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