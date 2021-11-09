package com.example.dictionary.dagger

import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dictionary.model.datasource.*
import com.example.dictionary.model.datasource.database.DictionaryDao
import com.example.dictionary.model.datasource.database.DictionaryDatabase
import com.example.dictionary.networkstatus.NetworkStatus
import com.example.dictionary.networkstatus.NetworkStatusInterface
import com.example.dictionary.view.DetailsFragment
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