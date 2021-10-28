package com.example.dictionary.dagger

import com.example.dictionary.networkstatus.NetworkStatusInterface
import com.example.dictionary.model.datasource.*
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
interface ProvidesModule {

    companion object {
        @Reusable
        @Provides
        fun provideApiHolder(): ApiHolder = ApiHolder()

        @Reusable
        @Provides
        fun provideLocalDataSource(): LocalDataSourceInterface = LocalDataSource()

        @Reusable
        @Provides
        fun provideRemoteDataSource(apiHolder: ApiHolder):
                RemoteDataSourceInterface = RemoteDataSource(apiHolder)

        @Reusable
        @Provides
        fun provideDataProvider (networkStatus: NetworkStatusInterface,
                                 remoteDataSource: RemoteDataSourceInterface,
                                 localDataSource: LocalDataSourceInterface
        )
            : DataProviderInterface = DataProvider(networkStatus, remoteDataSource, localDataSource)
    }
}