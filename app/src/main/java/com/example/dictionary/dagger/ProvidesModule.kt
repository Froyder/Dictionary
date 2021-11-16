package com.example.dictionary.dagger

import com.example.dataprovider.datasources.LocalDataSource
import com.example.dataprovider.datasources.LocalDataSourceInterface
import com.example.dataprovider.datasources.RemoteDataSource
import com.example.dataprovider.datasources.RemoteDataSourceInterface
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
interface ProvidesModule {

    companion object {
        @Reusable
        @Provides
        fun provideApiHolder(): com.example.dataprovider.ApiHolder =
            com.example.dataprovider.ApiHolder()

        @Reusable
        @Provides
        fun provideLocalDataSource(): LocalDataSourceInterface =
            LocalDataSource()

        @Reusable
        @Provides
        fun provideRemoteDataSource(apiHolder: com.example.dataprovider.ApiHolder):
                RemoteDataSourceInterface =
            RemoteDataSource(apiHolder)

//        @Reusable
//        @Provides
//        fun provideDataProvider (networkStatus: NetworkStatusInterface,
//                                 remoteDataSource: RemoteDataSourceInterface,
//                                 localDataSource: LocalDataSourceInterface
//        )
//            : DataProviderInterface =
//            DataProvider(networkStatus, remoteDataSource, localDataSource)
//
//
//        @Singleton
//        @Provides
//        fun provideViewModelFactory (dataProvider: DataProviderInterface)
//                : ViewModelFactory = ViewModelFactory(dataProvider)

    }
}